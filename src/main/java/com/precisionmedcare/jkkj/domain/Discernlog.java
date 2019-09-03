package com.precisionmedcare.jkkj.domain;


public class Discernlog {

  private long id;
  private java.sql.Timestamp upTime;
  private String tempPath;
  private String upUser;
  private String detectionId;
  private String patientId;
  private long isResult;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public java.sql.Timestamp getUpTime() {
    return upTime;
  }

  public void setUpTime(java.sql.Timestamp upTime) {
    this.upTime = upTime;
  }


  public String getTempPath() {
    return tempPath;
  }

  public void setTempPath(String tempPath) {
    this.tempPath = tempPath;
  }


  public String getUpUser() {
    return upUser;
  }

  public void setUpUser(String upUser) {
    this.upUser = upUser;
  }


  public String getDetectionId() {
    return detectionId;
  }

  public void setDetectionId(String detectionId) {
    this.detectionId = detectionId;
  }


  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }


  public long getIsResult() {
    return isResult;
  }

  public void setIsResult(long isResult) {
    this.isResult = isResult;
  }

}
