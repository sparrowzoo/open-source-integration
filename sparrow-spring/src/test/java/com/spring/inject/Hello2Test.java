package com.spring.inject;

import javax.inject.Named;

@Named
public class Hello2Test implements HelloApi {
    public void print() {
        System.out.println("hello2");
    }
}
