package com.mirbozorgi.shop.business.service;

import com.mirbozorgi.shop.business.domain.CategoryInfo;
import java.util.List;

public interface CategoryService {

  CategoryInfo add(String name);

  CategoryInfo update(int id, String name);

  CategoryInfo get(int categoryId);

  void delete(int categoryId);

  List<CategoryInfo> getAll();
}
