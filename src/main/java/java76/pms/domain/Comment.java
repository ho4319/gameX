package java76.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Comment implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int no;
  protected int memberNo;
  protected String text;
  protected Date createdDate;
 
  public Comment() {};
  
  @Override
  public String toString() {
    return "Comment [no=" + no + ", memberNo=" + memberNo + ", text=" + text + ", createdDate=" + createdDate + "]";
  }

  public int getNo() {
    return no;
  }
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public int getMemberNo() {
    return memberNo;
  }
  
  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
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
}