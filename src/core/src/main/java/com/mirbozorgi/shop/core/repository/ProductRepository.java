package com.mirbozorgi.shop.core.repository;

import com.mirbozorgi.shop.core.entity.Category;
import com.mirbozorgi.shop.core.entity.Product;
import java.util.List;

public interface ProductRepository {

  Product add(Product product);

  void update(
      int productId,
      String name,
      long price,
      String currency,
      String productImageUrl,
      Category category);

  Product get(int productId);

  void delete(int productId);

  List<Product> getAll(
      String name,
      Long minPrice,
      Long maxPrice,
      Integer categoryId);

  void changeSumOfRate(
      int id,
      int sumOfRates);

}
