package com.mirbozorgi.shop.api;

import com.mirbozorgi.shop.business.service.RateService;
import com.mirbozorgi.shop.model.RateAddModel;
import com.mirbozorgi.shop.util.helper.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/rate")
public class RateController {

  @Autowired
  private RateService rateService;


  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public ResponseEntity add(@Validated @RequestBody RateAddModel model) {
    return ResponseHelper.response(
        rateService.add(
            model.getRateValue(),
            model.getEmail(),
            model.getProductId()));
  }


  @RequestMapping(value = "/get-all", method = RequestMethod.GET)
  public ResponseEntity getAll(int userId) {
    return ResponseHelper
        .response(rateService.getAll(userId));
  }


  @RequestMapping(value = "/product/get-all", method = RequestMethod.GET)
  public ResponseEntity getAllProduct(int productId) {
    return ResponseHelper
        .response(rateService.getAllByProduct(productId));
  }


  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public ResponseEntity get(@RequestParam Integer id) {
    return ResponseHelper
        .response(rateService.get(id));
  }

}
