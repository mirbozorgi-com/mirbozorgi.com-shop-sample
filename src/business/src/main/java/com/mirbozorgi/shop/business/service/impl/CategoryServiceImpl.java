package com.mirbozorgi.shop.business.service.impl;

import com.mirbozorgi.shop.business.domain.CategoryInfo;
import com.mirbozorgi.shop.business.exception.CategoryExistException;
import com.mirbozorgi.shop.business.exception.NotFoundException;
import com.mirbozorgi.shop.business.mapper.CategoryMapper;
import com.mirbozorgi.shop.business.service.CategoryService;
import com.mirbozorgi.shop.core.entity.Category;
import com.mirbozorgi.shop.core.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository repository;

  @Transactional
  @Override
  public CategoryInfo add(String name) {

    Category category = repository.getByName(name);
    if (category != null) {
      throw new CategoryExistException();
    }

    category = repository.add(new Category(name));
    return CategoryMapper.toInfo(category);
  }

  @Transactional
  @Override
  public void update(int id, String name) {
    Category category = repository.get(id);
    if (category == null) {
      throw new NotFoundException();
    }
    category = repository.getByName(name);
    if (category != null) {
      throw new CategoryExistException();

    }

  }

  @Override
  public CategoryInfo get(int categoryId) {
    Category category = repository.get(categoryId);
    if (category == null) {
      throw new NotFoundException();
    }
    return CategoryMapper.toInfo(category);
  }

  @Transactional
  @Override
  public void delete(int categoryId) {
    repository.delete(categoryId);
  }

  @Override
  public List<CategoryInfo> getAll() {
    List<CategoryInfo> categoryInfos = new ArrayList<>();
    List<Category> all = repository.getAll();
    if (all == null) {
      return new ArrayList<>();
    }
    for (Category category :all ) {
      categoryInfos.add(CategoryMapper.toInfo(category));
    }

    return categoryInfos;
  }
}
