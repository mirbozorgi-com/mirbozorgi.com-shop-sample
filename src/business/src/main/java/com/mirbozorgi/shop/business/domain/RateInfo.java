package com.mirbozorgi.shop.business.domain;

public class RateInfo {

  private int rateValue;
  private String email;
  private String productName;
  private int productId;

  public RateInfo(
      int rateValue,
      String email,
      String productName,
      int productId) {
    this.rateValue = rateValue;
    this.email = email;
    this.productName = productName;
    this.productId = productId;
  }

  public int getRateValue() {
    return rateValue;
  }

  public String getEmail() {
    return email;
  }

  public String getProductName() {
    return productName;
  }

  public int getProductId() {
    return productId;
  }
}
