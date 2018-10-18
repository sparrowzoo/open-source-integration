package com.spring.mq;

import com.sparrow.mq.MQPublisher;
import com.sparrow.spring.SpringContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * created by harry on 2016/4/27.
 */
public class MQPublisherTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");


        ApplicationContext context= SpringContext.getContext();

        MQPublisher publisher = (MQPublisher) appContext.getBean("publisher");


        for(int i=0;i<50;i++) {
            System.out.println(i);
            //WorldEvent event = new WorldEvent();
            //event.setMessage(""+i);
            //publisher.publish(event);
        }

    }
}


