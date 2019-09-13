package com.sparrow.spring.controller;

import com.sparrow.spring.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HystrixController {
    @Autowired
    private HystrixService hystrixService;

    @RequestMapping("/hello")
    public String hello(String token) {
        String another_result = hystrixService.testHystrix("hello");
        return "another hystrix response:...." + another_result;
    }


    @RequestMapping(value = "/hystrix_anther_sleep", method = RequestMethod.GET)
    public String hystrixSlepp() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hystrix sleep 6s";
    }
}
