package com.spring.mysql;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by harry on 17/2/25.
 */
public class MysqlThreadTest {
    static ApplicationContext appContext = null;
    static DataSource ds = null;

    public static Integer threadCount = 10;

    public static Integer recordCount = 500000;

    public static void main(String[] args) throws SQLException {

        appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ds = (DataSource) appContext.getBean("springDataSource");
        Long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            Future future = executorService.submit(new MysqlThread());
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println("all times" + (System.currentTimeMillis() - start));
                break;
            }
        }
    }


    static class MysqlThread extends Thread {

        @Override
        public void run() {
            String sql = "INSERT INTO `zhuaququ`.`suser`\n" +
                    "(`UserLoginName`,\n" +
                    "`UserName`,\n" +
                    "`Password`,\n" +
                    "`HeadImg`,\n" +
                    "`Sex`,\n" +
                    "`Birthday`,\n" +
                    "`Email`,\n" +
                    "`Mobile`,\n" +
                    "`Cent`,\n" +
                    "`Activate`,\n" +
                    "`ActivateTime`,\n" +
                    "`CreateTime`,\n" +
                    "`UpdateTime`,\n" +
                    "`LastLoginTime`,\n" +
                    "`IP`,\n" +
                    "`IsOnline`,\n" +
                    "`PersonalSignature`,\n" +
                    "`Status`,\n" +
                    "`DomainName`,\n" +
                    "`Origin`,\n" +
                    "`Website`,\n" +
                    "`GroupLevel`,\n" +
                    "`SecretMobile`)\n" +
                    "VALUES\n" +
                    "(\"login name\",\n" +
                    "\"user\",\n" +
                    "\"password\",\n" +
                    "\"img\",\n" +
                    "0,\n" +
                    "\"1985-11-08\",\n" +
                    "\"zh_harry@163.com222\",\n" +
                    "\"13581579282\",\n" +
                    "0,\n" +
                    "0,\n" +
                    "\"2017-01-01\",\n" +
                    "\"2017-01-01\",\n" +
                    "\"2017-01-01\",\n" +
                    "\"2017-01-01\",\n" +
                    "\"192.168.9.1\",\n" +
                    "0,\n" +
                    "\"signature\",\n" +
                    "0,\n" +
                    "\"domain name\",\n" +
                    "\"test\",\n" +
                    "\"website\",\n" +
                    "\"mobile\",\n" +
                    "\"mobile secrit\");";

            Connection connection = null;
            try {
                connection = ds.getConnection();
                Long start = System.currentTimeMillis();
                for (int i = 0; i < recordCount / threadCount; i++) {
                    Statement statement = connection.createStatement();
                    statement.execute(sql);
                }
                System.out.println(Thread.currentThread().getId() + ":" + (System.currentTimeMillis() - start));
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }
}
