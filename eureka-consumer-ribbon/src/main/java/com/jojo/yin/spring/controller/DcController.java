package com.jojo.yin.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

@RestController
public class DcController {
  @Autowired
  RestTemplate restTemplate;

  @GetMapping("/consumer")
  public String dc() {
    return restTemplate.getForObject("http://eureka-client/dc", String.class);
  }
}
