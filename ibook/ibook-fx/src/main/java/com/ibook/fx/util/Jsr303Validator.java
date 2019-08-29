package com.ibook.fx.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Component
public class Jsr303Validator {

    @Autowired
    private Validator validator;

    public Validator getValidator() {
        return validator;
    }

    /**
     * @param t   需要校检的对象
     * @param <T>
     * @return 错误字段和信息的映射
     */
    public <T> Map<String, String> validated(T t, Class<?>... groups) {
//        t爲空，返回null
        if (t == null) {
            return null;
        }
//        对t进行校验
        Set<ConstraintViolation<T>> violations = validator.validate(t, groups);
//        校检内有错误
        return getFieldErrorMap(violations);
    }

    public <T> Map<String, String> validated(T t, String propertyName, Class<?>... groups) {
//        t爲空，返回null
        if (propertyName == null || t == null) {
            return null;
        }
//        对t进行校验
        Set<ConstraintViolation<T>> violations = validator.validateProperty(t, propertyName, groups);

        return getFieldErrorMap(violations);
    }

    public <T> Map<String, String> validated(Class<T> beanType, String propertyName, Object value, Class<?>... groups) {
//        t爲空，返回null
        if (propertyName == null || value == null) {
            return null;
        }
//        对t进行校验
        Set<ConstraintViolation<T>> violations = validator.validateValue(beanType, propertyName, value, groups);

        return getFieldErrorMap(violations);
    }

    private <T> Map<String, String> getFieldErrorMap(Set<ConstraintViolation<T>> violations) {

        Map<String, String> map = null;
        //        校检内有错误
        if (violations.size() == 0) {
            return null;
        } else {
            map = new HashMap<>();
//        保存错误信息：Map<Field,Message>
            Iterator<ConstraintViolation<T>> iterator = violations.iterator();
            ConstraintViolation<T> violation = null;
//            遍历校验信息
            while (iterator.hasNext()) {
                violation = iterator.next();
                String field = violation.getPropertyPath().toString();
                String message = violation.getMessage();
                map.put(field, message);
            }
            return map;
        }
    }
}