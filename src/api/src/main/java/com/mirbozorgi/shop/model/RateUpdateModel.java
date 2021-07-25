package com.mirbozorgi.shop.model;

import org.hibernate.validator.constraints.Range;

public class RateUpdateModel {

  @Range(min = 1, max = 5)
  private int rateValue;

  private int id;

  public int getRateValue() {
    return rateValue;
  }

  public int getId() {
    return id;
  }
}
