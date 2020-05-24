package com.ibook.service.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2019-10-15 16:55
 */
public class MybatisPlusTest {

    @Test
    public void test() {
        new LambdaQueryWrapper<>()
                .or(wrapper -> wrapper.eq(s -> "userId", "").eq(s -> "type", "0"))
                .orderByAsc(s -> "id");

        new QueryWrapper<>()
                .or(wrapper -> wrapper.eq("userId","").eq("type", "0"))
                .orderBy(true, true,"id", "tag");
    }

}
