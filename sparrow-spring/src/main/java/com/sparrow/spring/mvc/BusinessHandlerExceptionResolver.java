package com.sparrow.spring.mvc;

import com.alibaba.fastjson.JSON;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.Result;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * created by harry on 2016/3/25.
 */
//对接口HandlerExceptionResolver的实现会报错
public class BusinessHandlerExceptionResolver extends SimpleMappingExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
        Exception ex) {

        try {
            Result error = null;
            PrintWriter writer = response.getWriter();
            if (ex instanceof BusinessException) {
                BusinessException businessException = (BusinessException) ex;
                error = Result.fail(businessException);
            } else {
                error = Result.fail();
            }
            writer.write(JSON.toJSONString(error));
            writer.flush();
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}