package com.sparrow.lifecycle;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author by harry
 */
@Component
public class BeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {
    private static Logger logger = LoggerFactory.getLogger("LIFECYCLE");

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("{}-{} begin", this.getClass().getName(), "postProcessBeanFactory");
        Iterator<String> it = beanFactory.getBeanNamesIterator();
        while (it.hasNext()) {
            String beanName = it.next();
            if (beanName.contains("orderAssemble")) {
                logger.info("{}-{}-{}", this.getClass().getName(), "postProcessBeanFactory", "orderAssemble");
            }
            logger.info("{}-{}-{} ", this.getClass().getName(), "postProcessBeanFactory", beanName);
            //System.out.println(beanFactory.getBean(beanName));
        }
    }
}
