package java76.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Content  implements Serializable {
  private static final long serialVersionUID = 1L;

  protected int       no;
  protected String    title;
  protected String    writer;
  protected String    comment;
  protected int       views;
  protected Date      createdDate;
  protected String    attachFile;
  
  @Override
  public String toString() {
    return "Content [no=" + no + ", title=" + title + ", writer=" + writer + ", comment=" + comment + ", views=" + views
        + ", createdDate=" + createdDate + ", attachFile=" + attachFile + "]";
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
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
  
  public String getComment() {
    return comment;
  }
  
  public void setComment(String comment) {
    this.comment = comment;
  }
  
  public int getViews() {
    return views;
  }
  
  public void setViews(int views) {
    this.views = views;
  }
  
  public Date getCreatedDate() {
    return createdDate;
  }
  
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  
  public String getAttachFile() {
    return attachFile;
  }
  
  public void setAttachFile(String attachFile) {
    this.attachFile = attachFile;
  }
  
}