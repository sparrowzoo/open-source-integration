package com.sparrow.spring.api;

import com.sparrow.exception.BusinessException;

public interface HelloService {
    void sayHello() throws BusinessException;
}
