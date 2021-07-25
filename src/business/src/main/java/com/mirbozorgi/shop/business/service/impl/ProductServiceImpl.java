package com.mirbozorgi.shop.business.service.impl;

import com.mirbozorgi.shop.business.domain.ProductInfo;
import com.mirbozorgi.shop.business.exception.NotFoundException;
import com.mirbozorgi.shop.business.mapper.ProductMapper;
import com.mirbozorgi.shop.business.service.CommentService;
import com.mirbozorgi.shop.business.service.ProductService;
import com.mirbozorgi.shop.business.service.RateService;
import com.mirbozorgi.shop.core.entity.Category;
import com.mirbozorgi.shop.core.entity.Product;
import com.mirbozorgi.shop.core.repository.CategoryRepository;
import com.mirbozorgi.shop.core.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository repository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private CommentService commentService;

  @Autowired
  private RateService rateService;

  @Override
  public ProductInfo add(
      String name,
      String price,
      String currency,
      String productImageUrl,
      String category) {
    Category categoryFounded = categoryRepository.getByName(category);
    if (categoryFounded == null) {
      throw new NotFoundException();
    }
    Product product = new Product(
        name,
        price,
        currency,
        productImageUrl,
        categoryFounded
    );
    product = repository.add(product);

    return ProductMapper.toInfo(product, new ArrayList<>(), new ArrayList<>());
  }

  @Override
  public ProductInfo update(
      int productId,
      String name,
      String price,
      String currency,
      String productImageUrl,
      String categoryName) {
    Category categoryFounded = categoryRepository.getByName(categoryName);
    if (categoryFounded == null) {
      throw new NotFoundException();
    }
    Product product = repository.get(productId);
    if (product == null) {
      throw new NotFoundException();
    }

    product = repository.update(
        productId,
        name,
        price,
        currency,
        productImageUrl,
        categoryFounded
    );

    return ProductMapper.toInfo(
        product,
        commentService.getAllByProduct(productId),
        rateService.getAllByProduct(productId));
  }

  @Override
  public ProductInfo get(int productId) {
    Product product = repository.get(productId);
    if (product == null) {
      throw new NotFoundException();
    }

    return ProductMapper.toInfo(
        product,
        commentService.getAllByProduct(productId),
        rateService.getAllByProduct(productId));
  }

  @Override
  public void delete(int productId) {
    repository.delete(productId);
  }

  @Override
  public List<ProductInfo> getAll(
      String name,
      Integer minPrice,
      Integer maxPrice,
      Integer minRate,
      Integer maxRate,
      Integer categoryId) {
    return null;
  }
}
