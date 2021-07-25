package com.mirbozorgi.shop.business.domain;

import java.util.List;

public class ProductInfo {

  private String name;
  private long price;
  private String currency;
  private String productImageUrl;
  private String categoryName;
  private List<CommentInfo> commentInfos;
  private List<RateInfo> rateInfos;

  public ProductInfo(
      String name,
      long price,
      String currency,
      String productImageUrl,
      String categoryName,
      List<CommentInfo> commentInfos,
      List<RateInfo> rateInfos) {
    this.name = name;
    this.price = price;
    this.currency = currency;
    this.productImageUrl = productImageUrl;
    this.categoryName = categoryName;
    this.commentInfos = commentInfos;
    this.rateInfos = rateInfos;
  }

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

  public String getCategoryName() {
    return categoryName;
  }

  public List<CommentInfo> getCommentInfos() {
    return commentInfos;
  }

  public List<RateInfo> getRateInfos() {
    return rateInfos;
  }
}
