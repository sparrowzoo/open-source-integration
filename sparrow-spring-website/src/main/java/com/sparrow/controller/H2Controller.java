package com.sparrow.controller;

import com.sparrow.exception.BusinessException;
import com.sparrow.support.protocol.Result;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.h2.jdbcx.JdbcConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by harry on 2017/9/5.
 */
@Controller
@RequestMapping("/h2")
public class H2Controller {
    private static Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @Autowired
    private JdbcConnectionPool jdbcConnectionPool;

    @ResponseBody
    @RequestMapping("/hello-h2")
    public Result helloH2() throws BusinessException {
        logger.error("sparing error");
        Connection connection=null;
        try {
            connection= jdbcConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO TEST VALUES(3, 'World');");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Result.OK();
    }
}
