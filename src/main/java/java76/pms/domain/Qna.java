package java76.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Qna implements Serializable {
  private static final long serialVersionUID = 1L;

  protected String writer;
  protected String text;
  protected Date   createdDate;
  protected int    memberNo;
  protected int    no;
  protected String title;
 
  public Qna() {};
  
  @Override
  public String toString() {
    return "Qna [writer=" + writer + ", text=" + text + ", createdDate=" + createdDate + ", memberNo=" + memberNo
        + ", no=" + no + ", title=" + title + "]";
  }

  public String getWriter() {
    return writer;
  }
  
  public void setWriter(String writer) {
    this.writer = writer;
  }
  
  public String getText() {
    return text;
  }
  
  public void setText(String text) {
    this.text = text;
  }
  
  public Date getCreatedDate() {
    return createdDate;
  }
  
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  
  public int getMemberNo() {
    return memberNo;
  }
  
  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }
  
  public int getNo() {
    return no;
  }
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
}