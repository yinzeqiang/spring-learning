package com.jojo.yin.spring.controller;

import com.jojo.yin.spring.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

@RestController
public class DcController {
  @Autowired
  DcClient dcClient;

  @GetMapping("/consumer")
  public String dc() {
    return dcClient.consumer();
  }
}
