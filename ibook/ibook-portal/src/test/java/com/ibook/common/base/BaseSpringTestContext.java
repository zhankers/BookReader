package com.ibook.common.base;

import com.ibook.component.spring.base.SpringContextHelper;
import com.ibook.dubbo.service.user.UserServiceImpl;
import org.apache.dubbo.common.utils.Assert;
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
public class BaseSpringTestContext {

    @Test
    public void test() {
        UserServiceImpl bean = SpringContextHelper.getBean(UserServiceImpl.class);
        Assert.notNull(bean, "-----");
    }

}
