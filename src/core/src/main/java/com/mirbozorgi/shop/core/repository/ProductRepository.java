package com.mirbozorgi.shop.core.repository;

import com.mirbozorgi.shop.core.entity.Product;
import java.util.List;

public interface ProductRepository {

  Product add(Product product);

  Product update(Product product);

  Product get(int productId);

  Product delete(int productId);

  List<Product> getAll(
      String name,
      Integer minPrice,
      Integer maxPrice,
      Integer minRate,
      Integer maxRate);


}
