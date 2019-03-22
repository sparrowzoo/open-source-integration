package com.sparrow.spring.assemble;

import com.sparrow.spring.bo.HelloBO;
import com.sparrow.spring.po.Hello;

/**
 * @author: zh_harry@163.com
 * @date: 2019-03-22 11:16
 * @description:
 */
public class HelloAssemble {
    public Hello bo2po(HelloBO bo) {
        Hello h = new Hello();
        h.setMsg(bo.getMsg());
        h.setCreateUserId(bo.getCreateUserId());
        h.setCreateTime(System.currentTimeMillis());
        return h;
    }
}
