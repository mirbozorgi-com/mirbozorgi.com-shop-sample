package com.mirbozorgi.shop.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "prices")
  private long prices;

  @Column(name = "currency")
  private String currency;

  @Column(name = "product_image_url")
  private String productImageUrl;

  @Column(name = "sum_of_rates")
  private long sumOfRates;

  @OneToOne
  private Category category;

  public Product() {
  }

  public Product(
      String name,
      long prices,
      String currency,
      String productImageUrl,
      Category category) {
    this.name = name;
    this.prices = prices;
    this.currency = currency;
    this.productImageUrl = productImageUrl;
    this.sumOfRates = 0;
    this.category = category;
  }

  public Category getCategory() {
    return category;
  }

  public int getId() {
    return id;
  }

  public long getPrices() {
    return prices;
  }

  public String getCurrency() {
    return currency;
  }

  public String getProductImageUrl() {
    return productImageUrl;
  }

  public long getSumOfRates() {
    return sumOfRates;
  }

  public String getName() {
    return name;
  }
}
