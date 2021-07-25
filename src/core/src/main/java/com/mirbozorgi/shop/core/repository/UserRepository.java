package com.mirbozorgi.shop.core.repository;

import com.mirbozorgi.shop.core.entity.User;
import java.util.List;

public interface UserRepository {

  User add(User user);

  User update(User user);

  User getByEmail(String email);

  User delete(int userId);

  List<User> getAll();

}
