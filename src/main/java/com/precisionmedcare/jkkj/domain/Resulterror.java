package com.precisionmedcare.jkkj.domain;



public class Resulterror {

  private long id;
  private String upUser;
  private java.sql.Timestamp upTime;
  private String detectionId;
  private String patientId;
  private long groupId;
  private String errInfo;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUpUser() {
    return upUser;
  }

  public void setUpUser(String upUser) {
    this.upUser = upUser;
  }


  public java.sql.Timestamp getUpTime() {
    return upTime;
  }

  public void setUpTime(java.sql.Timestamp upTime) {
    this.upTime = upTime;
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


  public long getGroupId() {
    return groupId;
  }

  public void setGroupId(long groupId) {
    this.groupId = groupId;
  }


  public String getErrInfo() {
    return errInfo;
  }

  public void setErrInfo(String errInfo) {
    this.errInfo = errInfo;
  }

}
