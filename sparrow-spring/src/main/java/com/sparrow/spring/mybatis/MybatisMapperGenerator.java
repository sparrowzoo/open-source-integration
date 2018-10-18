package com.sparrow.spring.mybatis;

import com.sparrow.container.ClassFactoryBean;
import com.sparrow.orm.EntityManager;
import com.sparrow.orm.EntityManagerFactoryBean;
import com.sparrow.support.Entity;
import com.sparrow.support.EnvironmentSupport;
import com.sparrow.utility.FileUtility;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import javax.persistence.Table;
import java.io.File;
import java.util.Iterator;

public class MybatisMapperGenerator implements BeanFactoryPostProcessor {
    private String generatePath = "mapper";
    private ClassFactoryBean<EntityManager> entityManagerFactoryBean = EntityManagerFactoryBean.getInstance();

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Iterator<String> it = configurableListableBeanFactory.getBeanNamesIterator();
        while (it.hasNext()) {
            String beanName = it.next();
            if (!configurableListableBeanFactory.containsBeanDefinition(beanName)) {
                continue;
            }
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanName);
            try {
                Class clazz = Class.forName(beanDefinition.getBeanClassName());
                if (clazz.isAnnotationPresent(Table.class)) {
                    MybatisEntityManager mybatisEntityManager = new MybatisEntityManager(clazz);
                    entityManagerFactoryBean.pubObject(clazz, mybatisEntityManager);
                    FileUtility.getInstance().writeFile(EnvironmentSupport.getInstance().getClassesPhysicPath() + File.separator + this.generatePath + File.separator + "Sparrow" + clazz.getSimpleName() + "Mapper.xml", mybatisEntityManager.getXml());
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println("ok");
        }
    }
}
