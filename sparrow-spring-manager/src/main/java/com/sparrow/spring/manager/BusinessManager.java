package com.sparrow.spring.manager;

import com.mysql.jdbc.log.LogFactory;
import com.sparrow.spring.assemble.HelloAssemble;
import com.sparrow.spring.bo.HelloBO;
import com.sparrow.spring.dao.HelloDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zh_harry@163.com
 * @date: 2019-03-22 11:06
 * @description:
 */
public class BusinessManager {
    private Logger log = LoggerFactory.getLogger(BusinessManager.class);
    private HelloDAO helloDao;

    private HelloAssemble helloAssemble;

    public HelloBO service(HelloBO bo) {
        try {
            bo.setMsg("update msg");
            helloDao.save(this.helloAssemble.bo2po(bo));
            return bo;
        } catch (Throwable e) {
            log.error("update error", e);
            return null;
        }
    }
}
