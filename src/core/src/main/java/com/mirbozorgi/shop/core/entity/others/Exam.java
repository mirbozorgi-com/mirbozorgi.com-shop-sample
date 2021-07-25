package com.mirbozorgi.shop.core.entity.others;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "number")
  private long number;

  @ManyToMany(cascade = CascadeType.ALL)
  private Set<Student> students;

  public Exam(
      int id,
      long number) {
    this.id = id;
    this.number = number;
  }

  public int getId() {
    return id;
  }

  public long getNumber() {
    return number;
  }

}
