package com.spring;

import com.sparrow.spring.mvc.VOJsonMessageConverter;
import com.sparrow.spring.mvc.VOListJsonMessageConverter;
import com.sparrow.support.protocol.VO;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by harry on 2017/6/15.
 */
public class MessageConverterTest {
    public static void main(String[] args) {
        VOJsonMessageConverter messageConverter=new VOJsonMessageConverter();
        System.out.println(messageConverter.supports(VO.class));

        List<VO> baseVOS=new ArrayList<VO>();
        VOListJsonMessageConverter jsonMessageConverter=new VOListJsonMessageConverter();

        System.out.println(jsonMessageConverter.supports(baseVOS.getClass()));
    }
}
