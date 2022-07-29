package com.spring;

import com.spring.inject.HelloProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ContainerInjectTest {
    @Test
    public void test() {
        ApplicationContext appContext =
            new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloProvider helloProvider = (HelloProvider) appContext.getBean("helloProvider");
        helloProvider.getHelloTest().print();
    }
}
