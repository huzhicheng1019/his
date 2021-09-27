package cn.gson.his.model.pojos.Outpatient;



public class ReturnPremiumEntity {

  private String returnPremiumId;
  private java.sql.Date returnData;
  private String returnPatie;
  private String returnName;
  private Integer returnPrice;
  private String patientIdentity;
  private Integer premiumId;

  public Integer getPremiumId() {
    return premiumId;
  }

  public void setPremiumId(Integer premiumId) {
    this.premiumId = premiumId;
  }

  public String getReturnPremiumId() {
    return returnPremiumId;
  }

  public void setReturnPremiumId(String returnPremiumId) {
    this.returnPremiumId = returnPremiumId;
  }


  public java.sql.Date getReturnData() {
    return returnData;
  }

  public void setReturnData(java.sql.Date returnData) {
    this.returnData = returnData;
  }


  public String getReturnPatie() {
    return returnPatie;
  }

  public void setReturnPatie(String returnPatie) {
    this.returnPatie = returnPatie;
  }


  public String getReturnName() {
    return returnName;
  }

  public void setReturnName(String returnName) {
    this.returnName = returnName;
  }


  public Integer getReturnPrice() {
    return returnPrice;
  }

  public void setReturnPrice(Integer returnPrice) {
    this.returnPrice = returnPrice;
  }


  public String getPatientIdentity() {
    return patientIdentity;
  }

  public void setPatientIdentity(String patientIdentity) {
    this.patientIdentity = patientIdentity;
  }

}
