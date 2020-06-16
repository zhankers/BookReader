package com.ebook.learning.practice.condition;

import com.ebook.learning.practice.Practice;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-06-13 02:21
 */
public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 能获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        ClassLoader classLoader = context.getClassLoader();
        // 获取当前环境信息
        Environment environment = context.getEnvironment();

        String property = environment.getProperty("os.name");

        // 获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        beanDefinition.setBeanClass(Practice.class);

        registry.registerBeanDefinition("practice1", beanDefinition);


        MergedAnnotations annotations = metadata.getAnnotations();
        return false;
    }
}
