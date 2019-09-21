package com.sparrow.spring.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class Hystrix22Service {
    @HystrixCommand(commandKey = "testHystrix22",
            groupKey = "hystrixGroup2",
            threadPoolKey = "threadPool2",
            fallbackMethod = "timeOutFallBack",ignoreExceptions = {Exception.class},
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy",value = "THREAD"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000" )
            })
    public String testHystrix(String id) {
        int num=new Random().nextInt();
        if(num%100>2){
            return num+"";
        }
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Accept", "*/*");

        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9100/hystrix_anther_sleep", HttpMethod.GET, requestEntity,String.class);
        return exchange.getBody();
    }

    public String timeOutFallBack(String id){
        return "sorry-2, fall back";
    }
}
