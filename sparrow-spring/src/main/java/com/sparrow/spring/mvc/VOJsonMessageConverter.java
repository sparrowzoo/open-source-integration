package com.sparrow.spring.mvc;

import com.google.gson.Gson;
import com.sparrow.protocol.Result;
import com.sparrow.protocol.VO;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * created by harry on 2016/4/18.
 */
public class VOJsonMessageConverter extends AbstractHttpMessageConverter<VO> {
    public VOJsonMessageConverter() {
        super(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

    @Override
    public boolean supports(Class clazz) {
        return VO.class.isAssignableFrom(clazz);
    }

    @Override
    protected VO readInternal(Class<? extends VO> clazz,
        HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(VO result,
        HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        Gson gson = new Gson();
        Result<VO> voResult = new Result<VO>(result);
        if (result instanceof Result) {
            outputMessage.getBody().write(gson.toJson(result).getBytes());
            return;
        }

        outputMessage.getBody().write(gson.toJson(voResult).getBytes());
    }
}
