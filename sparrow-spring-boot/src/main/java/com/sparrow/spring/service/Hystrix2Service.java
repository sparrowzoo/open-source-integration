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
public class Hystrix2Service {
    @HystrixCommand(commandKey = "testHystrix2", groupKey = "hystrixGroup2",fallbackMethod = "timeOutFallBack",ignoreExceptions = {Exception.class},
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy",value = "THREAD"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000" )
            })
    public String testHystrix(String id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Accept", "*/*");

        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9100/hystrix_anther_sleep", HttpMethod.GET, requestEntity,String.class);
        return exchange.getBody();
    }

    public String timeOutFallBack(String id){
        return "sorry-2, the request is timeout";
    }
}
