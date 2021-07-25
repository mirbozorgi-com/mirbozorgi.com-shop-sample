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
@Table(name = "commnet")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "content")
  private String content;

  @Column(name = "creation_date")
  private long creationDate;

  @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
  @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_ID"), nullable = false)
  private User user;


  @OneToOne
  private Product product;

  public Comment() {
  }

  public Comment(String content,
      long creationDate,
      User user,
      Product product) {
    this.content = content;
    this.creationDate = creationDate;
    this.user = user;
    this.product = product;
  }

  public int getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public long getCreationDate() {
    return creationDate;
  }

  public User getUser() {
    return user;
  }

  public Product getProduct() {
    return product;
  }
}
