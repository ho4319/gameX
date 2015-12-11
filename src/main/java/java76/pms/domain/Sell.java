package java76.pms.domain;

import java.io.Serializable;

public class Sell implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected String genre;
  protected String style;
  protected int no;
  protected String photo;
  protected String text;
  protected String title;
  
  public Sell() {};
  
  @Override
  public String toString() {
    return "Sell [genre=" + genre + ", style=" + style + ", no=" + no + ", photo=" + photo + ", text=" + text
        + ", title=" + title + "]";
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getGenre() {
    return genre;
  }
  
  public void setGenre(String genre) {
    this.genre = genre;
  }
  
  public String getStyle() {
    return style;
  }
  
  public void setStyle(String style) {
    this.style = style;
  }
  
  public int getNo() {
    return no;
  }
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public String getPhoto() {
    return photo;
  }
  
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
}