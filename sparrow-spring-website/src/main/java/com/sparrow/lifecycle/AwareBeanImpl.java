package com.sparrow.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author by harry
 */
@Component
public class AwareBeanImpl implements ApplicationContextAware, BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private static Logger logger = LoggerFactory.getLogger("LIFECYCLE");
    private String beanName;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("{}-{} setBeanFactory",this.getClass().getName(),this.beanName);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        logger.info("{}-{} set bean name",this.getClass().getName(),name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("{}-{} setApplicationContext",this.getClass().getName(),this.beanName);
    }

    @Override
    public void destroy() throws Exception {
        logger.info("{}-{}  destroy",this.getClass().getName(),this.beanName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("{}-{} afterPropertiesSet",this.getClass().getName(),this.beanName);
    }
}
