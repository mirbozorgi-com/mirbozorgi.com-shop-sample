package com.mirbozorgi.shop.business.domain;

public class CommentInfo {

  private String content;
  private long creationDate;
  private String email;
  private String productName;
  private String productImageUrl;

  public CommentInfo(String content,
      long creationDate,
      String email,
      String productName,
      String productImageUrl) {
    this.content = content;
    this.creationDate = creationDate;
    this.email = email;
    this.productName = productName;
    this.productImageUrl = productImageUrl;
  }

  public String getContent() {
    return content;
  }

  public long getCreationDate() {
    return creationDate;
  }

  public String getEmail() {
    return email;
  }

  public String getProductName() {
    return productName;
  }

  public String getProductImageUrl() {
    return productImageUrl;
  }
}
