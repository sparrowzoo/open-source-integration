package com.sparrow.spring.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HystrixService {
    public String testHystrix(String id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Accept", "*/*");

        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9100/hystrix_anther_sleep", HttpMethod.GET, requestEntity,String.class);
        System.out.println("hello thread "+Thread.currentThread().getName());
        return exchange.getBody();
    }


}
