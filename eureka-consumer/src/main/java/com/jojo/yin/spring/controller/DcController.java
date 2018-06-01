package com.jojo.yin.spring.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

@RestController
public class DcController {
  @Autowired
  private LoadBalancerClient loadBalancerClient;
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/consumer")
  public String dc() {
    ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
    String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
    System.out.println(url);
    return restTemplate.getForObject(url, String.class);
  }

  @GetMapping("/consumer1")
  public String dc1() {
    ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
    String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc1";
    System.out.println(url);
    Map<String,String> tmp=restTemplate.getForObject(url, Map.class);
    return tmp.toString();
  }
}
