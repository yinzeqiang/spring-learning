package com.jojo.yin.spring.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

@RestController
public class DcController {

  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/dc")
  public String dc() {
    String services = "Services: " + discoveryClient.getServices();
    System.out.println(services);
    return services;
  }

  @GetMapping("/dc1")
  public Map<String, String> dc1() {
    Map<String, String> map = new HashMap<String, String>(3);
    map.put("a", "1");
    map.put("b", "2");
    map.put("c", "3");
    return map;
  }
}
