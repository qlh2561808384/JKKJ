package com.precisionmedcare.jkkj.domain;


public class Logincode {

  private long id;
  private String activecode;
  private long status;
  private long userid;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getActivecode() {
    return activecode;
  }

  public void setActivecode(String activecode) {
    this.activecode = activecode;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }

}
