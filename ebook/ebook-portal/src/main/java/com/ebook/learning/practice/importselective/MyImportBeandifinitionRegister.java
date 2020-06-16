package com.ebook.learning.practice.importselective;

import com.ebook.learning.practice.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-06-13 02:47
 */
public class MyImportBeandifinitionRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {

    }

    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinitionRegistry： BeanDefinition注册类
     *                 把所有需要添加到容器中的bean，调用registerBeanDefinition方法手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("red");
        boolean blue = registry.containsBeanDefinition("blue");
        if (red && blue) {
            //
            RootBeanDefinition rootBeanDefinition2 = new RootBeanDefinition(RainBow.class);
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
            rootBeanDefinition.setBeanClass(RainBow.class);

            registry.registerBeanDefinition("rainbow", rootBeanDefinition);
        }
    }
}
