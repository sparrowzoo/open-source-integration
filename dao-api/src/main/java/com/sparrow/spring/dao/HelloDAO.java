package com.sparrow.spring.dao;

import com.sparrow.spring.dto.HelloDTO;
import com.sparrow.spring.po.Hello;
import com.sparrow.spring.query.HelloQuery;

import java.util.List;

/**
 * @author: zh_harry@163.com
 * @date: 2019-03-22 11:19
 * @description:
 */
public interface HelloDAO {
    /**
     * save po
     * @param hello
     */
    void save(Hello hello);

    /**
     * save dto
     * @param hello
     */
    void update(HelloDTO hello);

    /**
     * query po
     * @param query
     * @return
     */
    List<Hello> query(HelloQuery query);

    /**
     * query dto
     * @param query
     * @return
     */
    List<HelloDTO> queryDto(HelloQuery query);

    /**
     * get po
     */
    Hello get(int id);

    /**
     * get dto
     * @param id
     * @return
     */
    HelloDTO getDto(int id);
}
