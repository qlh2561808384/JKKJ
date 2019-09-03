package com.precisionmedcare.jkkj.domain;

/*
*   数据库的dateTime类型  可以接收String 跟Date类型的
* */
public class Resultgroup {

  private long id;
  private String upUser;
  private String detectionId;
  private String patientId;
  private String upTime;
  private long isResult;
  private String reResult;
  private String reText;
  private String doctorNotes;
  private String errInfo;
  private long isErr;
  private String ip;
  private String date;
  private String city;
  private double size;


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


  public String getUpTime() {
    return upTime;
  }

  public void setUpTime(String upTime) {
    this.upTime = upTime;
  }


  public long getIsResult() {
    return isResult;
  }

  public void setIsResult(long isResult) {
    this.isResult = isResult;
  }


  public String getReResult() {
    return reResult;
  }

  public void setReResult(String reResult) {
    this.reResult = reResult;
  }


  public String getReText() {
    return reText;
  }

  public void setReText(String reText) {
    this.reText = reText;
  }


  public String getDoctorNotes() {
    return doctorNotes;
  }

  public void setDoctorNotes(String doctorNotes) {
    this.doctorNotes = doctorNotes;
  }


  public String getErrInfo() {
    return errInfo;
  }

  public void setErrInfo(String errInfo) {
    this.errInfo = errInfo;
  }


  public long getIsErr() {
    return isErr;
  }

  public void setIsErr(long isErr) {
    this.isErr = isErr;
  }


  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public double getSize() {
    return size;
  }

  public void setSize(double size) {
    this.size = size;
  }

}
