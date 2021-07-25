package com.mirbozorgi.shop.core.repository.impl;

import com.mirbozorgi.shop.core.entity.UserSecurity;
import com.mirbozorgi.shop.core.enums.Role;
import com.mirbozorgi.shop.core.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends CustomRepository implements UserRepository {

  @Override
  public UserSecurity add(UserSecurity userSecurity) {
    return save(UserSecurity.class, userSecurity);
  }

  @Override
  public UserSecurity update(
      String email,
      String password,
      Role role,
      long lastLoginDate,
      Boolean verifyEmail,
      String verificationCode,
      long verificationCodeCreatedDate,
      String forgetPassToken,
      long createdForgetPassTokenDate,
      long verifiedDate) {

    int i = entityManager.createQuery("update UserSecurity set"
        + " password = :password ,"
        + " role = :role ,"
        + " lastLoginDate = :lastLoginDate ,"
        + " verifyEmail = :verifyEmail ,"
        + " verificationCode = :verificationCode ,"
        + " verificationCodeCreatedDate = :verificationCodeCreatedDate ,"
        + " createdForgetPassTokenDate = :createdForgetPassTokenDate ,"
        + " verifiedDate = :verifiedDate ,"
        + " forgetPassToken = :forgetPassToken "
        + " Where email = :email "

    )
        .setParameter("email", email)
        .setParameter("password", password)
        .setParameter("role", role)
        .setParameter("lastLoginDate", lastLoginDate)
        .setParameter("verifyEmail", verifyEmail)
        .setParameter("verificationCode", verificationCode)
        .setParameter("verificationCodeCreatedDate", verificationCodeCreatedDate)
        .setParameter("createdForgetPassTokenDate", createdForgetPassTokenDate)
        .setParameter("verifiedDate", verifiedDate)
        .setParameter("forgetPassToken", forgetPassToken)
        .executeUpdate();
    ;
    return getByEmail(email);
  }

  @Override
  public UserSecurity getByEmail(String email) {
    return findQueryWrapper(entityManager
        .createQuery("select u from UserSecurity u where u.email= :email ",
            UserSecurity.class)
        .setParameter("email", email));
  }

  @Override
  public UserSecurity get(int userId) {
    return findById(UserSecurity.class, userId);
  }

  @Override
  public void delete(int userId) {
    UserSecurity userSecurity = get(userId);
    delete(UserSecurity.class, userSecurity);
  }

  @Override
  public List<UserSecurity> getAll() {
    return listQueryWrapper(entityManager.createQuery(
        "select g from UserSecurity g order by g.id desc ",
        UserSecurity.class));
  }
}
