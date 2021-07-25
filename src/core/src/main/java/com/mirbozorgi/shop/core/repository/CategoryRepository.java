package com.mirbozorgi.shop.core.repository;

import com.mirbozorgi.shop.core.entity.Category;
import java.util.List;

public interface CategoryRepository {

  Category add(Category category);

  void update(int id, String name);

  Category get(int categoryId);

  Category getByName(String name);

  void delete(int categoryId);

  List<Category> getAll();

}
