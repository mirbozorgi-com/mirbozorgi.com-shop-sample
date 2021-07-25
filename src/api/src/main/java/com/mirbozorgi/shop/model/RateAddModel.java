package com.mirbozorgi.shop.model;

import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.Range;

public class RateAddModel {

  @Range(min = 1, max = 5)
  private int rateValue;
  @Email
  private String email;
  private int productId;

  public int getRateValue() {
    return rateValue;
  }

  public String getEmail() {
    return email;
  }

  public int getProductId() {
    return productId;
  }
}
