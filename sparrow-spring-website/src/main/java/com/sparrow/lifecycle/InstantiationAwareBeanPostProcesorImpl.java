package com.sparrow.lifecycle;

import java.beans.PropertyDescriptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author by harry
 */
@Component
public class InstantiationAwareBeanPostProcesorImpl implements InstantiationAwareBeanPostProcessor {
    private static Logger logger = LoggerFactory.getLogger("LIFECYCLE");
    @Override public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        logger.info("{}-{}-{}",this.getClass().getName(),"postProcessBeforeInstantiation",beanName);
        return null;
    }

    @Override public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        logger.info("{}-{}-{}",this.getClass().getName(),"postProcessAfterInstantiation",beanName);
        return false;
    }

    @Override public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
        String beanName) throws BeansException {
        logger.info("{}-{}-{}",this.getClass().getName(),"postProcessPropertyValues",beanName);
        return pvs;
    }

    @Override public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("{}-{}-{}",this.getClass().getName(),"postProcessBeforeInitialization",beanName);
        return bean;
    }

    @Override public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("{}-{}-{}",this.getClass().getName(),"postProcessAfterInitialization",beanName);
        return bean;
    }
}
