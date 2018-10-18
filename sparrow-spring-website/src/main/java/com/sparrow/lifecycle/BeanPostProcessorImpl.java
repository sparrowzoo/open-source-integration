package com.sparrow.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author by harry
 */
@Component
public class BeanPostProcessorImpl implements BeanPostProcessor {
    private static Logger logger = LoggerFactory.getLogger("LIFECYCLE");
    @Override public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("{}-{}-{}",this.getClass().getName(),"postProcessBeforeInitialization",beanName);
        if(beanName.contains("orderAssemble")){
            logger.info("{}-{}-{}-exist order assemble",this.getClass().getName(),"postProcessBeforeInitialization",beanName);
        }
        return bean;
    }

    @Override public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("{}-{}-{}",this.getClass().getName(),"postProcessAfterInitialization",beanName);
        return bean;
    }
}
