package com.ebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.WebApplicationInitializer;

@PropertySource(value = {
        "classpath:META-INF/spring/application.properties",
        "classpath:META-INF/spring/durid.properties"
})
@EnableAspectJAutoProxy
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EbookApplication {

    public static void main(String[] args) {
        System.out.println(WebApplicationInitializer.class.isInterface());

        SpringApplication.run(EbookApplication.class, args);
    }

}

