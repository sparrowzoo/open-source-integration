package com.sparrow.test;

import com.sparrow.constant.SPARROW_ERROR;
import com.sparrow.spring.SPRING_ERROR;

/**
 * Created by harry on 2017/6/27.
 */
public class SparrowTest {
    public static void main(String[] args) {
        System.out.println(SPARROW_ERROR.SYSTEM_ILLEGAL_REQUEST.name());
        System.out.println(SPRING_ERROR.SPARROW_ERROR.name());
    }
}
