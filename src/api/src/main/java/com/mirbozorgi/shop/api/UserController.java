package com.mirbozorgi.shop.api;

import com.mirbozorgi.shop.business.context.aop.anotions.Auth;
import com.mirbozorgi.shop.business.service.UserSecurityService;
import com.mirbozorgi.shop.model.BlockModel;
import com.mirbozorgi.shop.model.UserSecurityModel;
import com.mirbozorgi.shop.util.helper.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserSecurityService securityService;

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ResponseEntity register(@Validated @RequestBody UserSecurityModel model) {
    return ResponseHelper.response(
        securityService.userSignUp(model.getEmail(), model.getPassword())

    );
  }

  @RequestMapping(value = "/admin/register", method = RequestMethod.POST)
  public ResponseEntity adminRegister(@Validated @RequestBody UserSecurityModel model) {
    return ResponseHelper.response(
        securityService.adminSignUp(model.getEmail(), model.getPassword())

    );
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity login(@Validated @RequestBody UserSecurityModel model) {
    return ResponseHelper.response(
        securityService.signIn(model.getEmail(), model.getPassword())

    );
  }

  @Auth
  @RequestMapping(value = "/block", method = RequestMethod.POST)
  public ResponseEntity block(@Validated @RequestBody BlockModel model) {

    securityService.blockUser(
        model.getUserId(),
        model.getBlock()
    );
    return ResponseHelper.response(true);

  }
}
