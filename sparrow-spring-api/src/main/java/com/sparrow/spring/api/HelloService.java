package com.sparrow.spring.api;

import com.sparrow.exception.BusinessException;
import com.sparrow.spring.dto.HelloDTO;

public interface HelloService {
    HelloDTO sayHello() throws BusinessException;
}
