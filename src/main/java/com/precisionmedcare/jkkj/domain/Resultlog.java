package com.precisionmedcare.jkkj.domain;



public class Resultlog {

  private long id;
  private String upUser;
  private String  upTime;
  private String detectionId;
  private String patientId;
  private long groupId;
  private String imgPath;
  private String reResult;
  private String reSpace;
  private String reText;
  private long isRe;


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


  public String getUpTime() {
    return upTime;
  }

  public void setUpTime(String upTime) {
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


  public String getImgPath() {
    return imgPath;
  }

  public void setImgPath(String imgPath) {
    this.imgPath = imgPath;
  }


  public String getReResult() {
    return reResult;
  }

  public void setReResult(String reResult) {
    this.reResult = reResult;
  }


  public String getReSpace() {
    return reSpace;
  }

  public void setReSpace(String reSpace) {
    this.reSpace = reSpace;
  }


  public String getReText() {
    return reText;
  }

  public void setReText(String reText) {
    this.reText = reText;
  }


  public long getIsRe() {
    return isRe;
  }

  public void setIsRe(long isRe) {
    this.isRe = isRe;
  }

}
