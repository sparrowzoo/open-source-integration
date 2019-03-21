package com.sparrow.spring.api.impl;

import com.sparrow.protocol.BusinessException;
import com.sparrow.spring.api.HelloService;
import com.sparrow.spring.dto.HelloDTO;
import com.sparrow.spring.query.HelloQuery;

public class HelloServiceImpl implements HelloService {
    public HelloDTO sayHello(HelloQuery query) throws BusinessException {
       return new HelloDTO();
        //System.out.println("hello world");
        //throw new BusinessException(SPARROW_ERROR.SYSTEM_SERVER_ERROR);
    }
}
