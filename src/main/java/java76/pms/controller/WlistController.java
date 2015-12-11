package java76.pms.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java76.pms.dao.WlistDao;
import java76.pms.domain.Wlist;

@Controller
@RequestMapping("/wlist/*")
public class WlistController {
  @Autowired WlistDao wlistDao;
  @Autowired ServletContext servletContext;

  @RequestMapping("list")
  public String list(HttpServletRequest request) throws Exception {

    List<Wlist> wlists = wlistDao.selectList();

    request.setAttribute("wlists", wlists);

    return "wlist/WlistList";

  }
  
  @RequestMapping("delete")
  public String delete(Wlist wlist, Model model) throws Exception {

    if (wlistDao.delete(wlist) <= 0) {
      model.addAttribute("errorCode", "401");
      return "wlist/WlistAuthError";
    }
    return "redirect:list.do";
  }
}