package com.spring.inject;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
public class HelloTest implements HelloApi {
    public void print() {
        System.out.println("hello");
    }
}
