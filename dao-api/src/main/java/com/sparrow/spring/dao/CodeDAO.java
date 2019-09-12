package com.sparrow.spring.dao;

import com.sparrow.protocol.db.DaoSupport;
import com.sparrow.spring.dto.HelloDTO;
import com.sparrow.spring.po.Code;
import com.sparrow.spring.query.HelloQuery;

public interface CodeDAO extends DaoSupport<Code, String> {
    HelloDTO query(HelloQuery query);
}
