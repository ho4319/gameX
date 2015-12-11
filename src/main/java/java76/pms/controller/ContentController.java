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

import java76.pms.dao.ContentDao;
import java76.pms.domain.Content;
import java76.pms.util.MultipartHelper;

@Controller
@RequestMapping("/content/*")
public class ContentController { 
  
  public static final String SAVED_DIR = "/attachfile";
  
  @Autowired ContentDao contentDao;
  @Autowired ServletContext servletContext;
  
  @RequestMapping("list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="4") int pageSize,
      HttpServletRequest request) {
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    
    List<Content> allContents = contentDao.paging();
    int cnt = 0;
    for(Content contmp : allContents) {
      cnt++;
    }
    
    cnt = (int)Math.ceil(cnt / 4.0);
    
    request.setAttribute("cnt", cnt);
    
    int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 

    request.setAttribute("temp", temp);
    
    List<Content> contents = contentDao.selectList(paramMap);

    request.setAttribute("contents", contents);

    return "content/ContentList";
  }
  
  @RequestMapping(value="search", method=RequestMethod.GET)
  public String search(
      @RequestParam(defaultValue="0") int no, 
      Model model) throws Exception {
    if (no <= 0) {
      model.addAttribute("errorCode", "400");
      return "content/ContentAuthError";
    }
    
    Content content = contentDao.search(no);
    model.addAttribute("content", content);
    return "content/ContentSearch";
  }

  
  @RequestMapping(value="add", method=RequestMethod.GET)
  public String form() {
    return "content/ContentForm";
  }
  
  @RequestMapping(value="add", method=RequestMethod.POST)
  public String add(Content content, MultipartFile file, Model model) throws Exception {
    
    if (file.getSize() > 0) {
      String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
      File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
          + "/" + newFileName);
      file.transferTo(attachfile);
      content.setAttachFile(newFileName);
    } else {
      model.addAttribute("errorCode", "null");
      return "content/ContentAuthError";
    }

    contentDao.insert(content);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) throws Exception {
    
    Content content = null;
    
    contentDao.addViews(no);
    model.addAttribute("content", content);
    
    content = contentDao.selectOne(no);
    model.addAttribute("content", content);
    return "content/ContentDetail";
  }
  
  @RequestMapping("updateForm")
  public String updateForm(int no, Model model) throws Exception {
    
    Content content = null;
    
    contentDao.addViews(no);
    model.addAttribute("content", content);
    
    content = contentDao.selectOne(no);
    model.addAttribute("content", content);
    return "content/ContentUpdateForm";
  }

  @RequestMapping(value="update", method=RequestMethod.POST)
  public String update(
      Content content, MultipartFile file, Model model) throws Exception {
    
    if (file.getSize() > 0) {
      String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
      File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
                                          + "/" + newFileName);
      file.transferTo(attachfile);
      content.setAttachFile(newFileName);
    } else if (content.getAttachFile().length() == 0) {
      content.setAttachFile(null);
    }
    
    if (contentDao.update(content) <= 0) {
      model.addAttribute("errorCode", "401");
      return "content/ContentAuthError";
    } 
    
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(int no, Model model) 
      throws Exception {
    
    if (contentDao.delete(no) <= 0) {
      model.addAttribute("errorCode", "401");
      return "content/ContentAuthError";
    } 

    return "redirect:list.do";
  }
  
}
