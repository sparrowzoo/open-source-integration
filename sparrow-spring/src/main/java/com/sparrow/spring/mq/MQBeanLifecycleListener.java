package com.sparrow.spring.mq;

import com.sparrow.mq.MQHandler;
import com.sparrow.mq.QueueHandlerMappingContainer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * created by harry on 2016/4/27.
 */
public class MQBeanLifecycleListener implements BeanPostProcessor {
    @Autowired
    private QueueHandlerMappingContainer container;


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean name->"+beanName);
        if (MQHandler.class.isAssignableFrom(bean.getClass())) {
            container.put((MQHandler) bean);
        }
        return bean;
    }
}
