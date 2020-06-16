package com.ebook.learning.practice;

import com.ebook.learning.practice.bean.A;
import com.ebook.learning.practice.condition.LinuxCondition;
import com.ebook.learning.practice.factorybean.ColorFactoryBean;
import com.ebook.learning.practice.importselective.MyImportSelective;
import com.ebook.learning.practice.typefilter.MyTypeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-06-13 02:06
 * <p>
 * <p>
 * 给容器注册bean组件
 */

/**
 * 1）：包扫描+组件标注注解（@Component
 */
@ComponentScans({
        @ComponentScan(value = "", includeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        })
})

/**
 * 2）@Bean【导入的第三方包里面的组件】
 *
 */
@Conditional(LinuxCondition.class)

/**
 * 3）：@Import注解【快速向容器中导入一个组件】
 *   1，要导入到容器的组件
 *   2，MyImportSelective，返回需要导入的组件的全类名数组
 *   3，ImportBeanDefinitionRegistrar: 手动注册bean到容器中
 */
@Import({A.class, MyImportSelective.class})

/**
 * 4): 使用spring提供的FactoryBean（工厂bean）
 */
public class Practice {


    /**
     * 使用colorFactoryBean为bean名称的将会获取Color的实例
     * 如果想要获取ColorFactoryBean对象本身，需要加前缀& 即bean名称为"&colorFactoryBean"
     */
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }

}
