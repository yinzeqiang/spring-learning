package com.jojo.yin.spring.webfilter;

import com.fangjia.common.filter.HttpBasicAuthorizeFilter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/5/18 0018.
 */

@Configuration
public class FilterConfig {

  @Bean
  public FilterRegistrationBean filterRegistrationBean() {
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    HttpBasicAuthorizeFilter httpBasicFilter = new HttpBasicAuthorizeFilter();
    registrationBean.setFilter(httpBasicFilter);
    List<String> urlPatterns = new ArrayList<String>(1);
    urlPatterns.add("/*");
    registrationBean.setUrlPatterns(urlPatterns);
    return registrationBean;
  }
}
