package com.mirbozorgi.shop.api;

import com.mirbozorgi.shop.business.service.ProductService;
import com.mirbozorgi.shop.model.DeleteModel;
import com.mirbozorgi.shop.model.ProductAddModel;
import com.mirbozorgi.shop.model.ProductUpdateModel;
import com.mirbozorgi.shop.util.helper.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductService productService;


  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public ResponseEntity add(@RequestBody ProductAddModel model) {
    return ResponseHelper.response(
        productService.add(
            model.getName(),
            model.getPrice(),
            model.getCurrency(),
            model.getProductImageUrl(),
            model.getCategory()
        )
    );
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public ResponseEntity update(@RequestBody ProductUpdateModel model) {
    productService.update(
        model.getId(),
        model.getName(),
        model.getPrice(),
        model.getCurrency(),
        model.getProductImageUrl(),
        model.getCategory()
    );

    return ResponseHelper.response(true);

  }

  @RequestMapping(value = "/get-all", method = RequestMethod.GET)
  public ResponseEntity getAll(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) Integer minPrice,
      @RequestParam(required = false) Integer maxPrice,
      @RequestParam(required = false) Integer minRate,
      @RequestParam(required = false) Integer maxRate,
      @RequestParam(required = false) String category) {

    return ResponseHelper.response(productService.getAll(
            name,
            minPrice,
            maxPrice,
            minRate,
            maxRate,
            category));
  }

  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public ResponseEntity get(@RequestParam Integer id) {
    return ResponseHelper
        .response(productService.get(id));
  }

  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  public ResponseEntity delete(@RequestBody DeleteModel model) {
    productService.delete(model.getId());
    return ResponseHelper.response(true);
  }

}
