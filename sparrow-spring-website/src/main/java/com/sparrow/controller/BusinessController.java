package com.sparrow.controller;

import com.sparrow.assemble.HelloAssemble;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.pager.PagerQuery;
import com.sparrow.protocol.pager.SimplePagerResult;
import com.sparrow.spring.manager.BusinessManager;
import com.sparrow.spring.query.HelloQuery;
import com.sparrow.vo.HelloVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zh_harry@163.com
 * @date: 2019-03-22 11:06
 * @description:
 */
public class BusinessController {

    @Autowired
    private BusinessManager manager;

    @Autowired
    private HelloAssemble helloAssemble;

    @ResponseBody
    @RequestMapping("/hello-service")
    public HelloVO hello(HelloQuery vo) throws BusinessException {
        Integer userId=0;//GET FROM TOKEN
        return this.helloAssemble.bo2vo(
                manager.service(this.helloAssemble.vo2bo(vo,userId)));
    }
}
