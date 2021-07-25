package com.mirbozorgi.shop.core.entity.others;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "school")
public class School {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
  private Set<Student> students;


  public School(
      Long id,
      String name,
      String address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }
}
