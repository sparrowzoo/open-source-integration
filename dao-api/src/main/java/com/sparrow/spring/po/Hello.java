package com.sparrow.spring.po;

/**
 * @author: zh_harry@163.com
 * @date: 2019-03-22 11:17
 * @description:
 */
public class Hello {
    private String msg;

    private Integer createUserId;
    private Long createTime;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
