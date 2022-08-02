package com.spring.inject;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class HelloProvider {
    @Inject
    @Named("hello2Test")
    private HelloApi helloApi;

    public HelloApi getHelloTest() {
        return helloApi;
    }
}
