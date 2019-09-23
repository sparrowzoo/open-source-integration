package com.sparrow.spring.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sparrow.spring.service.Hystrix22Service;
import com.sparrow.spring.service.Hystrix2Service;
import com.sparrow.spring.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class HystrixController {
    @Autowired
    private HystrixService hystrixService;

    @Autowired
    private Hystrix2Service hystrix2Service;

    @Autowired
    private Hystrix22Service hystrix22Service;

    @HystrixCommand(commandKey = "testHystrix", groupKey = "hystrixGroup",fallbackMethod = "timeOutFallBack",ignoreExceptions = {Exception.class},
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy",value = "THREAD"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000" )
            })
    @RequestMapping("/hello")
    public Mono<String> hello(String token) {
        System.out.println("hello thread "+Thread.currentThread().getName());
        return Mono.create(sink -> {
                    String hello = Thread.currentThread().getName()+" another hystrix response:...." + hystrixService.testHystrix("hello");
                    sink.success(hello);
                }
        );
    }

    @RequestMapping("/hello-2")
    public String hello2(String token) {
        String another_result = hystrix2Service.testHystrix("hello");
        return "another hystrix response:...." + another_result;
    }

    @RequestMapping("/hello-22")
    public String hello22(String token) {
        String another_result = hystrix22Service.testHystrix("hello");
        return "another hystrix response:...." + another_result;
    }


    @RequestMapping(value = "/hystrix_anther_sleep", method = RequestMethod.GET)
    public String hystrixSlepp() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hystrix sleep 5 s";
    }

    public Mono<String> timeOutFallBack(String id){
        return Mono.just("sorry, the request is timeout");
    }
}
