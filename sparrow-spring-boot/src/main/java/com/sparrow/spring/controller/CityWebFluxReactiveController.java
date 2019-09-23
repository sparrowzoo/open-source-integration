package com.sparrow.spring.controller;

import com.sparrow.spring.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;

@RestController
@RequestMapping(value = "/user")
public class CityWebFluxReactiveController {

    @Autowired
    private ReactiveRedisTemplate reactiveRedisTemplate;

    @GetMapping(value = "/{id}")
    public Mono<UserVO> findUserById(@PathVariable("id") Long id) throws IOException {
        String key = "user_" + id;
        System.out.println(key + " " + Thread.currentThread().getName());
        ReactiveValueOperations<String, UserVO> operations = reactiveRedisTemplate.opsForValue();
        Mono<UserVO> userId = operations.get(key);

        userId = userId
                .map(userVO -> {
                            userVO.setUserName("update harry");
                            System.out.println(key + " map thread " + Thread.currentThread().getName());
                            return userVO;
                        }
                )
                .publishOn(Schedulers.newElastic("publish"))//影响后序operator
                .subscribeOn(Schedulers.newElastic("订阅-sparrow"))//只影响source
                .filter(userVO -> {
                    System.out.println(key + " filter thread " + Thread.currentThread().getName());
                    return true;
                });

//        userId.subscribe(userVO -> {
//            System.out.println(key + " subscribe thread " + Thread.currentThread().getName());
//        });

        System.out.println(key + " current thread " + Thread.currentThread().getName());
        return userId;
    }

    //@PostMapping("save-user")
    @GetMapping("save-user/{id}")
    public Mono<UserVO> saveUser(@PathVariable("id") Long id) {
        System.out.println(Thread.currentThread().getName());
        UserVO user = new UserVO();
        user.setUserId(id);
        user.setUserName("harry");
        String key = "user_" + user.getUserId();
        ReactiveValueOperations<String, UserVO> operations = reactiveRedisTemplate.opsForValue();
        System.out.println(Thread.currentThread().getName());
        return operations.getAndSet(key, user);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long> deleteUser(@PathVariable("id") Long id) {
        String key = "user_" + id;
        return reactiveRedisTemplate.delete(key);
    }
}
