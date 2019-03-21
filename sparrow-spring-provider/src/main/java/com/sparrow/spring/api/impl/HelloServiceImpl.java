package com.sparrow.spring.api.impl;

import com.sparrow.exception.BusinessException;
import com.sparrow.spring.api.HelloService;
import com.sparrow.spring.dto.HelloDTO;

public class HelloServiceImpl implements HelloService {
    public HelloDTO sayHello() throws BusinessException {
       return new HelloDTO();
        //System.out.println("hello world");
        //throw new BusinessException(SPARROW_ERROR.SYSTEM_SERVER_ERROR);
    }
}
