package com.ebook.learning.practice.typefilter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-06-13 02:08
 */
public class MyTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        // 获取当前正在扫描的类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        // 获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        // 获取当前类资源（类的路径等信息）
        Resource resource = metadataReader.getResource();

        System.out.println("-->"+ classMetadata.getClassName());


        MetadataReader metadataReader1 = metadataReaderFactory.getMetadataReader(classMetadata.getClassName());
        MetadataReader metadataReader2 = metadataReaderFactory.getMetadataReader(resource);



        return false;
    }
}
