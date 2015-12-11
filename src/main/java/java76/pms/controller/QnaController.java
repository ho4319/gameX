package java76.pms.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.dao.QnaDao;
import java76.pms.domain.Qna;

@Controller
@RequestMapping("/qna/*")
public class QnaController { 
  
  @Autowired QnaDao qnaDao;
  @Autowired ServletContext servletContext;
  
  @RequestMapping("list")
  public String list(HttpServletRequest request) {
    
    List<Qna> qnas = qnaDao.selectList();

    request.setAttribute("qnas", qnas);

    return "qna/QnaList";
  }
  
  @RequestMapping(value="add", method=RequestMethod.GET)
  public String form() {
    return "qna/QnaForm";
  }
  
  @RequestMapping(value="add", method=RequestMethod.POST)
  public String add(Qna qna, Model model) throws Exception {
    
    qnaDao.insert(qna);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) throws Exception {
    
    Qna qna = null;
    
    qna = qnaDao.selectOne(no);
    model.addAttribute("qna", qna);
    return "qna/QnaDetail";
  }
  
  @RequestMapping(value="update", method=RequestMethod.POST)
  public String update(Qna qna, Model model) throws Exception {
    
    if (qnaDao.update(qna) <= 0) {
      model.addAttribute("errorCode", "401");
      return "qna/QnaAuthError";
    } 
    
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(int no, Model model) 
      throws Exception {
    
    if (qnaDao.delete(no) <= 0) {
      model.addAttribute("errorCode", "401");
      return "qna/QnaAuthError";
    } 

    return "redirect:list.do";
  }
  
}