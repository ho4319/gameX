package java76.pms.domain;

import java.io.Serializable;

public class Wlist implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int productNo;
  protected int memberNo;
  
  public Wlist() {}

  @Override
  public String toString() {
    return "Wlist [productNo=" + productNo + ", memberNo=" + memberNo + "]";
  }

  public int getProductNo() {
    return productNo;
  }

  public void setProductNo(int productNo) {
    this.productNo = productNo;
  }

  public int getMemberNo() {
    return memberNo;
  }

  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  };
}