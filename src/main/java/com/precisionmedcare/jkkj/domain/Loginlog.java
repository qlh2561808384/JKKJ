package com.precisionmedcare.jkkj.domain;


public class Loginlog {

  private long id;
  private String userId;
  private java.sql.Timestamp logTime;
  private long logType;


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


  public java.sql.Timestamp getLogTime() {
    return logTime;
  }

  public void setLogTime(java.sql.Timestamp logTime) {
    this.logTime = logTime;
  }


  public long getLogType() {
    return logType;
  }

  public void setLogType(long logType) {
    this.logType = logType;
  }

}
