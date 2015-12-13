/*package search;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // 페이징 작업 시작.
    // DB 테이블의 모든 정보를 읽는다.
    List<Content> allContents = contentDao.paging();
    int cnt = 0;
    for(Content contmp : allContents) {
      cnt++;
    }
    
    // cnt를 pageSize로 나누어서 페이지 개수를 구한다.(소수점 이하 반올림)
    cnt = (int)Math.ceil(cnt / 4.0);
    
    request.setAttribute("cnt", cnt);
    
    int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 

    request.setAttribute("temp", temp);
    
    List<Content> contents = contentDao.selectList(paramMap);

    request.setAttribute("contents", contents);

    return "content/ContentList";
  }
  
  // 검색 부분
  @RequestMapping(value="search", method=RequestMethod.GET)
  public String search(
      String keyword,
      @RequestParam(defaultValue="0") String searchword,
      Model model) throws Exception {

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("keyword", keyword);
    if (keyword.equals("no")) { // 만약 글 번호로 검색했다면
      if (Integer.parseInt(searchword) == 0) { // 검색어가 입력되지 않았다면, 오류발생 페이지로
        model.addAttribute("errorCode", "400");
        return "content/ContentAuthError";
      }
      
      paramMap.put("no", searchword);
    } else { // 제목으로 검색했다면
      if (searchword.equals("0")){ // 검색어가 입력되지 않으면
        model.addAttribute("errorCode", "400");
        return "content/ContentAuthError";
      }
      searchword = "%" + searchword + "%"; // 앞뒤의 %는 searchword를 포함하는 제목을 검색하라는 의미
      // %가 앞에 있다면 searchword로 끝나는 모든 제목을 검색하고, 뒤에 있다면 searchword로 시작하는 모든 제목을 검색한다.
      paramMap.put("title", searchword);
    }
    
    
    List<Content> contents = contentDao.search(paramMap);
    model.addAttribute("contents", contents);
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
*/