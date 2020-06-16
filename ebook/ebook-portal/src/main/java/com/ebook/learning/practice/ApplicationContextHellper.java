package com.ebook.learning.practice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-06-13 02:19
 */
public class ApplicationContextHellper implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        BeanFactory parentBeanFactory = applicationContext.getParentBeanFactory();
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        Environment environment = applicationContext.getEnvironment();

        Resource resource = applicationContext.getResource("");
    }
}
