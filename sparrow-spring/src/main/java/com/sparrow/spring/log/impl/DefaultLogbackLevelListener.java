package com.sparrow.spring.log.impl;


import com.sparrow.spring.log.AbstractLogbackLevelListener;

/**
 * Created by harry on 2017/4/19.
 */
public class DefaultLogbackLevelListener extends AbstractLogbackLevelListener {

    private String key="logBackLevel";

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getLevel() {
        //read from config
        return "info";
    }
}
