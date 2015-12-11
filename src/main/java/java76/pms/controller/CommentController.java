package java76.pms.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.dao.CommentDao;
import java76.pms.domain.Comment;

@Controller
@RequestMapping("/comment/*")
public class CommentController {  
  @Autowired CommentDao commentDao;
  @Autowired ServletContext servletContext;
  
  @RequestMapping("list")
  public String list(HttpServletRequest request) throws Exception {
    
   List<Comment> comments = commentDao.selectList();
    
    request.setAttribute("comments", comments);
    
    return "comment/CommentList";
  }
  
  @RequestMapping(value="add", method=RequestMethod.GET)
  public String form() {
    return "comment/CommentForm";
  }
  
  @RequestMapping("add")
  public String add(Comment comment) throws Exception {
    
    commentDao.insert(comment); 

    return "redirect:list.do";
  }
  
  @RequestMapping(value="update", method=RequestMethod.POST)
  public String update(Comment comment, Model model) 
          throws Exception {

    if (commentDao.update(comment) <= 0) {
      model.addAttribute("errorCode", "401");
      return "comment/CommentAuthError";
    } 

    return "redirect:list.do";

  }
  
  @RequestMapping("delete")
  public String delete(
      Comment comment,
      HttpServletRequest request) throws Exception {

    if (commentDao.delete(comment) <= 0) {
      request.setAttribute("errorCode", "401");
      return "comment/CommentAuthError";
    } 

    return "redirect:list.do";
  }
}
