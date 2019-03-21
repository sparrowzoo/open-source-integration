package com.sparrow.spring.api;

import com.sparrow.protocol.BusinessException;
import com.sparrow.spring.dto.HelloDTO;
import com.sparrow.spring.query.HelloQuery;

public interface HelloService {
    HelloDTO sayHello(HelloQuery query) throws BusinessException;
}
