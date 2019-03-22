package com.sparrow.assemble;

import com.sparrow.spring.bo.HelloBO;
import com.sparrow.spring.query.HelloQuery;
import com.sparrow.vo.HelloVO;

/**
 * @author: zh_harry@163.com
 * @date: 2019-03-22 11:03
 * @description:
 */
public class HelloAssemble {
    public HelloBO vo2bo(HelloQuery vo, Integer createUserId) {
        HelloBO bo = new HelloBO();
        bo.setMsg(vo.getMsg());
        bo.setCreateUserId(createUserId);
        return bo;
    }


    public HelloVO bo2vo(HelloBO bo) {
        HelloVO vo = new HelloVO();
        bo.setMsg(vo.getMsg());
        return vo;
    }
}
