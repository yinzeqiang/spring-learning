package com.jojo.yin.spring;

import com.fangjia.api.client.auth.AuthRemoteClientHystrix;
import com.fangjia.api.client.config.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

@FeignClient(value = "eureka-client",configuration = FeignConfiguration.class)
public interface DcClient {

  @GetMapping("/dc")
  String consumer();
}
