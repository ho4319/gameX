package java76.pms.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java76.pms.dao.SellDao;
import java76.pms.domain.Sell;
import java76.pms.util.MultipartHelper;

@Controller
@RequestMapping("/sell/*")
public class SellController { 
  @Autowired SellDao sellDao;
  @Autowired ServletContext servletContext;
  
  @RequestMapping("list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize,
      HttpServletRequest request) {
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    
    List<Sell> sells = sellDao.selectList(paramMap);

    request.setAttribute("sells", sells);

    return "sell/SellList";
  }
  
  @RequestMapping(value="add", method=RequestMethod.GET)
  public String form() {
    return "sell/SellForm";
  }
  
  @RequestMapping(value="add", method=RequestMethod.POST)
  public String add(Sell sell, MultipartFile file, Model model) throws Exception {
    
    if (file.getSize() > 0) {
      String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
      File attachfile = new File(servletContext.getRealPath("/sPhoto") 
          + "/" + newFileName);
      file.transferTo(attachfile);
      sell.setPhoto(newFileName);
    } else {
      model.addAttribute("errorCode", "null");
      return "sell/SellAuthError";
    }
    
    sellDao.insert(sell);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) throws Exception {
    
    Sell sell = null;
    
    sell = sellDao.selectOne(no);
    model.addAttribute("sell", sell);
    return "sell/SellDetail";
  }
  
  @RequestMapping(value="update", method=RequestMethod.POST)
  public String update(
      Sell sell, MultipartFile file, Model model) throws Exception {
    
    if (file.getSize() > 0) {
      String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
      File attachfile = new File(servletContext.getRealPath("/sPhoto") 
                                          + "/" + newFileName);
      file.transferTo(attachfile);
      sell.setPhoto(newFileName);
    } else if (sell.getPhoto().length() == 0) {
      sell.setPhoto(null);
    }
    
    if (sellDao.update(sell) <= 0) {
      model.addAttribute("errorCode", "401");
      return "sell/SellAuthError";
    } 
    
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(int no, Model model) 
      throws Exception {
    
    if (sellDao.delete(no) <= 0) {
      model.addAttribute("errorCode", "401");
      return "sell/SellAuthError";
    } 

    return "redirect:list.do";
  }
  
}