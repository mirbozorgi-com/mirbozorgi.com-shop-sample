package com.mirbozorgi.shop.model;

public class ProductAddModel {

  private String name;
  private long price;
  private String currency;
  private String productImageUrl;
  private String category;

  public String getName() {
    return name;
  }

  public long getPrice() {
    return price;
  }

  public String getCurrency() {
    return currency;
  }

  public String getProductImageUrl() {
    return productImageUrl;
  }

  public String getCategory() {
    return category;
  }
}
