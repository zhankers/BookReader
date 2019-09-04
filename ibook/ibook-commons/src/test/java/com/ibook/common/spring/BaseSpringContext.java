package com.ibook.common.spring;

import com.ibook.component.spring.base.SpringContextHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2019-08-31 23:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseSpringContext {

    @Test
    public void test() {
        SpringContextHelper.getBean("");
    }

}
