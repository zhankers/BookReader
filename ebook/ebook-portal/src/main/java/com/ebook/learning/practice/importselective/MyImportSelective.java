package com.ebook.learning.practice.importselective;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-06-13 02:37
 */
public class MyImportSelective implements ImportSelector {

    /**
     *
     * @param importingClassMetadata : 获取标注@import注解的类的所有的注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {


        // importingClassMetadata.get

        // 导入Yellow 和Blue的bean
        return new String[]{"com.ebook.learning.practice.bean.Yellow", "com.ebook.learning.practice.bean.Blue"};
    }
}
