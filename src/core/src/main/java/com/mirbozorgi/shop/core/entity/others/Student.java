package com.mirbozorgi.shop.core.entity.others;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name", nullable = false)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY, targetEntity = School.class)
  @JoinColumn(name = "school_id", foreignKey = @ForeignKey(name = "FK_SCHOOL"), nullable = false)
  private School school;

  @ManyToMany(mappedBy = "students")
  @JoinTable
  private Set<Exam> exams;

  public Student(
      long id,
      String name,
      School school,
      Set<Exam> exams) {
    this.id = id;
    this.name = name;
    this.school = school;
    this.exams = exams;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public School getSchool() {
    return school;
  }

  public Set<Exam> getExams() {
    return exams;
  }
}
