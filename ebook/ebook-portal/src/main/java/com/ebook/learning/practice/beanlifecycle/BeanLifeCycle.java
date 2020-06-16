package com.ebook.learning.practice.beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-06-13 03:12
 */
public class BeanLifeCycle implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void destroy() throws Exception {

    }
}
