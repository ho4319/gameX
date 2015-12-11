package java76.pms.domain;

import java.io.Serializable;

public class Member implements Serializable {
  private static final long serialVersionUID = 1L;

  protected String id;
  protected String name;
  protected String address;
  protected String photo;
  protected String email;
  protected String password;
  protected int    no;
  protected int    grade;
  
  public Member() {};
  
  @Override
  public String toString() {
    return "Member [id=" + id + ", name=" + name + ", address=" + address + ", photo=" + photo + ", email=" + email
        + ", password=" + password + ", no=" + no + ", grade=" + grade + "]";
  }

  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public String getPhoto() {
    return photo;
  }
  
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public int getNo() {
    return no;
  }
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public int getGrade() {
    return grade;
  }
  
  public void setGrade(int grade) {
    this.grade = grade;
  }
}