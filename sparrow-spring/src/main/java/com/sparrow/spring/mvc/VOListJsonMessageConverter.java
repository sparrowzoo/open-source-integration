package com.sparrow.spring.mvc;

import com.google.gson.Gson;
import com.sparrow.support.protocol.Result;
import com.sparrow.support.protocol.VO;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/**
 * created by harry on 2016/4/18.
 */
public class VOListJsonMessageConverter extends AbstractHttpMessageConverter<List<VO>> {
    public VOListJsonMessageConverter() {
        super(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

    @Override
    public boolean supports(Class clazz) {
        if(List.class.getTypeParameters()==null||List.class.getTypeParameters().length==0){
            return false;
        }
        return List.class.getTypeParameters()[0].getGenericDeclaration().isAssignableFrom(clazz);
    }

    @Override
    protected List<VO> readInternal(Class<? extends List<VO>> clazz,
        HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void writeInternal(List<VO> voList,
        HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        Gson gson = new Gson();
        Result<List<VO>> result=new Result<List<VO>>(voList);
        outputMessage.getBody().write(gson.toJson(result).getBytes());
    }
}
