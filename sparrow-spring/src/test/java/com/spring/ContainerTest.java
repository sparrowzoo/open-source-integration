package com.spring;

import com.sparrow.spring.SpringContext;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * RABBIT MQ CONSUMER created by harry on 2016/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ContainerTest {
    @Test
    public void test() {
        ApplicationContext appContext =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        DataSource cf = (DataSource) appContext.getBean("dataSource");
        for (int i = 0; i < 1; i++) {
            try {
                cf.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end....");
//        RabbitAdmin admin3 = new RabbitAdmin(cf);
//        for(int i=0;i<1000;i++) {
//            admin3.deleteQueue("myQueue"+i);
//        }



        /*
        TopicExchange exchange = new TopicExchange("myExchange");
        admin.declareExchange(exchange);
        admin.declareBinding(
                BindingBuilder.bind(queue).to(exchange).with("foo.*"));
 */
    }
}
