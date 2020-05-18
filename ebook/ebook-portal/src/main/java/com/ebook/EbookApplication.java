package com.ebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = {
        "classpath:META-INF/spring/application.properties",
        "classpath:META-INF/spring/durid.properties"
})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbookApplication.class, args);
    }

}

