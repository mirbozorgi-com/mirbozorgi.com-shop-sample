package com.mirbozorgi.shop.business.service.impl;

import com.mirbozorgi.shop.business.domain.AuthorizationInfo;
import com.mirbozorgi.shop.business.domain.UserInfo;
import com.mirbozorgi.shop.business.exception.NotFoundException;
import com.mirbozorgi.shop.business.exception.UserCredentialException;
import com.mirbozorgi.shop.business.exception.UserEmailExistException;
import com.mirbozorgi.shop.business.mapper.UserMapper;
import com.mirbozorgi.shop.business.service.JwtService;
import com.mirbozorgi.shop.business.service.StringService;
import com.mirbozorgi.shop.business.service.TimeService;
import com.mirbozorgi.shop.business.service.UserSecurityService;
import com.mirbozorgi.shop.core.entity.UserSecurity;
import com.mirbozorgi.shop.core.enums.Role;
import com.mirbozorgi.shop.core.repository.UserSecurityRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {

  @Autowired
  private UserSecurityRepository repository;

  @Autowired
  private StringService stringService;

  @Autowired
  private TimeService timeService;

  @Autowired
  private JwtService jwtService;

  @Transactional
  @Override
  public UserInfo userSignUp(
      String email,
      String password) {
    UserSecurity userFounded = repository.getByEmail(email);
    long nowTime = timeService.getNowUnixFromInstantClass();
    //encrypt the password
    password = stringService.toMd5(password);

    if (userFounded != null) {
      throw new UserEmailExistException();
    }
    //because we do not have SMPT for sending email to user so
    // we verify all user manually
    userFounded = new UserSecurity(
        email,
        password,
        Role.USER,
        0,
        nowTime,
        true,
        stringService.generateRandomString(true, true, 6),
        0,
        "",
        0,
        0);

    return UserMapper.toInfo(repository.add(userFounded));
  }

  @Transactional
  @Override
  public UserInfo adminSignUp(
      String email,
      String password) {
    UserSecurity userFounded = repository.getByEmail(email);
    long nowTime = timeService.getNowUnixFromInstantClass();
    //encrypt the password
    password = stringService.toMd5(password);

    if (userFounded != null) {
      throw new UserEmailExistException();
    }
    //because we do not have SMPT for sending email to user so
    // we verify all user manually
    userFounded = new UserSecurity(
        email,
        password,
        Role.ADMIN,
        0,
        nowTime,
        true,
        stringService.generateRandomString(true, true, 6),
        0,
        "",
        0,
        0);

    return UserMapper.toInfo(repository.add(userFounded));
  }

  @Override
  public UserInfo findByEmail(String email) {
    UserSecurity user = repository.getByEmail(email);
    if (user == null) {
      throw new NotFoundException();
    }
    return UserMapper.toInfo(user);
  }

  @Override
  public String signIn(
      String email,
      String password) {
    UserSecurity userFounded = repository.getByEmail(email);
    if (userFounded == null) {
      throw new NotFoundException();
    }
    if (!stringService.toMd5(password).equals(userFounded.getPassword())) {
      throw new UserCredentialException();
    }

    return jwtService.createToken(
        userFounded.getEmail(),
        userFounded.getRole());

  }

  @Override
  public AuthorizationInfo authorize(String token) {

    return jwtService.authorize(token);
  }

/* TODO : all bottom services are for forgetPasswords flow
  which you can impelement it but be aware you neeed smpt or sms services to
  notify users
  */

  @Override
  public void verify(
      String email,
      String verificationCode) {

  }

  @Override
  public void reGenerateVerificationCode(String email) {

  }

  @Override
  public void changePassword(
      String email,
      String password,
      String newPassword) {

  }

  @Override
  public void forgetPassword(
      String email,
      String password,
      String forgetPasswordToken) {

  }

  @Override
  public void sendForgetPassToken(String email) {
  }
}
