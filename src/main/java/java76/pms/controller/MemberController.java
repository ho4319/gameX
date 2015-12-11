/*package java76.pms.controller;

import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.dao.MemberDao;
import java76.pms.domain.Member;

@Controller
@RequestMapping("/member/*")
public class MemberController {
  @Autowired MemberDao memberDao;
  @Autowired ServletContext servletContext;

  @RequestMapping(value="join", method=RequestMethod.GET)
  public String form() {
    return "member/join";
  }
  
  @RequestMapping(value="join", method=RequestMethod.POST)
  public String add(Member member, Model model){
    try {
      String email = member.getEmail();
      String regex = "\\w+@\\w+\\.\\w+";
      String password = member.getPassword();
      String rePassword = member.getRePassword();
      
      boolean emailCheck = Pattern.matches(regex, email);
      
      if (emailCheck == false) {
        model.addAttribute("errorCode", "regex");
        return "member/MemberAuthError";
      } else if (!(password.equals(rePassword))) {
        model.addAttribute("errorCode", "pwd");
        return "member/MemberAuthError";
      }
      
      
      memberDao.insert(member);
      
      return "redirect:../auth/login.do";
    } catch (Exception e) {
      model.addAttribute("errorCode", "500");
      return "member/MemberAuthError";
    }
  }
}*/