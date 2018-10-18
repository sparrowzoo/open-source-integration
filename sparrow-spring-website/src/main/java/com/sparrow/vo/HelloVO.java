package com.sparrow.vo;

import com.sparrow.support.protocol.VO;

/**
 * Created by harry on 2017/6/15.
 */
public class HelloVO implements VO{
    public HelloVO() {
    }

    public HelloVO(String msg, String name, String age) {
        this.msg = msg;
        this.name=name;
        this.age=age;
    }

    private String msg;
    private String name;
    private String age;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
