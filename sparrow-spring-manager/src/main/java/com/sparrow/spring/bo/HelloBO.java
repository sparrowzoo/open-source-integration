package com.sparrow.spring.bo;

/**
 * @author: zh_harry@163.com
 * @date: 2019-03-22 11:04
 * @description:
 */
public class HelloBO {
    private String msg;
    private Integer createUserId;

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
