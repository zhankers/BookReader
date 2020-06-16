package com.ebook.learning.practice.factorybean;

import com.ebook.learning.practice.bean.Color;
import org.springframework.beans.factory.FactoryBean;


/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-06-13 03:00
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    /**
     * 返回一个color对象，这个对象会添加到容器中
     * @return
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否是单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
