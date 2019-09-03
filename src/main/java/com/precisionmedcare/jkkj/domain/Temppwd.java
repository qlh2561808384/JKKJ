package com.precisionmedcare.jkkj.domain;


public class Temppwd {

  private long id;
  private String userId;
  private java.sql.Timestamp staticTime;
  private String staticPwd;
  private long isUse;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public java.sql.Timestamp getStaticTime() {
    return staticTime;
  }

  public void setStaticTime(java.sql.Timestamp staticTime) {
    this.staticTime = staticTime;
  }


  public String getStaticPwd() {
    return staticPwd;
  }

  public void setStaticPwd(String staticPwd) {
    this.staticPwd = staticPwd;
  }


  public long getIsUse() {
    return isUse;
  }

  public void setIsUse(long isUse) {
    this.isUse = isUse;
  }

}
