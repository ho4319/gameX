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

import java76.pms.dao.MemberDao;
import java76.pms.domain.Member;
import java76.pms.util.MultipartHelper;

@Controller
@RequestMapping("/member/*")
public class MemberController {
  
  @Autowired MemberDao memberDao;
  @Autowired ServletContext servletContext;

  @RequestMapping("list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize,
        HttpServletRequest request) throws Exception {

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    
    List<Member> members = memberDao.selectList(paramMap);

    request.setAttribute("members", members);

    return "member/MemberList";

  }
  
  @RequestMapping(value="add", method=RequestMethod.GET)
  public String form() {
    return "member/MemberForm";
  }
  
  @RequestMapping(value="add", method=RequestMethod.POST)
  public String add(Member member, MultipartFile photofile) throws Exception {

    if (photofile.getSize() > 0) {
      String newFileName = MultipartHelper.generateFilename(photofile.getOriginalFilename());  
      File attachfile = new File(servletContext.getRealPath("/mPhoto") 
                                 + "/" + newFileName);
      photofile.transferTo(attachfile);
      member.setPhoto(newFileName);
      
    }

    memberDao.insert(member);

    return "redirect:list.do";

  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) 
          throws Exception {

    Member member = memberDao.selectOne(no);
    model.addAttribute("member", member);
    return "member/MemberDetail";
  }

  @RequestMapping(value="update", method=RequestMethod.POST)
  public String post(
      Member member, MultipartFile photofile, Model model) throws Exception {

    if (photofile.getSize() > 0) {
      String newFileName = MultipartHelper.generateFilename(photofile.getOriginalFilename());  
      File attachfile = new File(
          servletContext.getRealPath("/mPhoto") + "/" + newFileName);
      photofile.transferTo(attachfile);
      member.setPhoto(newFileName);
    }
    
    if (memberDao.update(member) <= 0) {
      model.addAttribute("errorCode", "401");
      return "member/MemberAuthError";
    } 

    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(int no, Model model) throws Exception {

    if (memberDao.delete(no) <= 0) {
      model.addAttribute("errorCode", "401");
      return "member/MemberAuthError";
    }
    return "redirect:list.do";
  }
}
