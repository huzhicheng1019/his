package cn.gson.his.model.pojos.Outpatient;


import java.sql.Timestamp;

public class ReturnPremiumEntity {

  private int returnPremiumId;
  private Timestamp returnData;
  private int returnPatie;
  private String returnName;
  private Long returnPrice;
  private String patientIdentity;
  private Integer premiumId;

  public Integer getPremiumId() {
    return premiumId;
  }

  public void setPremiumId(Integer premiumId) {
    this.premiumId = premiumId;
  }

  public int getReturnPremiumId() {
    return returnPremiumId;
  }

  public void setReturnPremiumId(int returnPremiumId) {
    this.returnPremiumId = returnPremiumId;
  }


  public Timestamp getReturnData() {
    return returnData;
  }

  public void setReturnData(Timestamp returnData) {
    this.returnData = returnData;
  }


  public int getReturnPatie() {
    return returnPatie;
  }

  public void setReturnPatie(int returnPatie) {
    this.returnPatie = returnPatie;
  }


  public String getReturnName() {
    return returnName;
  }

  public void setReturnName(String returnName) {
    this.returnName = returnName;
  }


  public Long getReturnPrice() {
    return returnPrice;
  }

  public void setReturnPrice(Long returnPrice) {
    this.returnPrice = returnPrice;
  }


  public String getPatientIdentity() {
    return patientIdentity;
  }

  public void setPatientIdentity(String patientIdentity) {
    this.patientIdentity = patientIdentity;
  }

}
