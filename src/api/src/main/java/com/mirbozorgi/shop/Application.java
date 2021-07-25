package com.mirbozorgi.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.mirbozorgi")
@EntityScan(basePackages = {"com.mirbozorgi.shop.core.entity"})
@EnableJpaRepositories(basePackages = "com.mirbozorgi.shop.core.repository")
public class Application {

  public static void main(String[] args) {

    SpringApplication.run(Application.class, args);
  }
}
