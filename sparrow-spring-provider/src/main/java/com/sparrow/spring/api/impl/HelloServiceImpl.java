package com.sparrow.spring.api.impl;

import com.sparrow.constant.SPARROW_ERROR;
import com.sparrow.exception.BusinessException;
import com.sparrow.spring.api.HelloService;

public class HelloServiceImpl implements HelloService {
    public void sayHello() throws BusinessException {
        System.out.println("hello world");
        throw new BusinessException(SPARROW_ERROR.SYSTEM_SERVER_ERROR);
    }
}
