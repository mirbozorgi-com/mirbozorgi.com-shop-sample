package com.mirbozorgi.shop.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "rate")
public class Rate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "rate_value")
  private int rateValue;

  @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserSecurity.class)
  @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_ID"), nullable = false)
  private UserSecurity userSecurity;

  @OneToOne
  private Product product;

  public Rate() {
  }

  public Rate(int rateValue,
      UserSecurity userSecurity,
      Product product) {
    this.rateValue = rateValue;
    this.userSecurity = userSecurity;
    this.product = product;
  }

  public int getId() {
    return id;
  }

  public int getRateValue() {
    return rateValue;
  }

  public UserSecurity getUser() {
    return userSecurity;
  }

  public Product getProduct() {
    return product;
  }
}
