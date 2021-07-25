package com.mirbozorgi.shop.business.service;

import com.mirbozorgi.shop.business.domain.ProductInfo;
import com.mirbozorgi.shop.core.entity.Category;
import com.mirbozorgi.shop.core.entity.Product;
import java.util.List;

public interface ProductService {

  ProductInfo add(
      String name,
      long price,
      String currency,
      String productImageUrl,
      String category);

  void update(
      int productId,
      String name,
      long price,
      String currency,
      String productImageUrl,
      String  categoryName);

  ProductInfo get(int productId);

  void delete(int productId);

  List<ProductInfo> getAll(
      String name,
      Long minPrice,
      Long maxPrice,
      String  category);


}
