package com.ebook.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import static com.ebook.common.constant.BaseConstant.dateFormat;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-01-12 01:48
 */
public class JsonUtil {

    private static ObjectMapper objectMapper;
    private static ObjectMapper xmlMapper ;

    static {
        // 默认的ObjectMapper
        objectMapper = new ObjectMapper();
        xmlMapper = new XmlMapper();

        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 所有日期格式都统一为固定格式
        objectMapper.setDateFormat(new SimpleDateFormat(dateFormat));

        //设置null时候不序列化(只针对对象属性)
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        //单引号处理
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

    }
    /**
     * 将对象转化为json数据
     *
     * @param obj the obj
     *
     * @return string string
     *
     * @throws IOException the io exception
     */
    public static String toJsonString(Object obj) {
        Preconditions.checkArgument(obj != null, "this argument is required; it must not be null");
        String jsonStr = "";
        try {
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    /**
     * json数据转化为对象(JavaType)
     *
     * @param <T>       the type parameter
     * @param jsonValue the json value
     * @param valueType the value type
     *
     * @return t t
     *
     * @throws IOException the io exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T parseObject(String jsonValue, JavaType valueType) throws IOException {
        Preconditions.checkArgument(StringUtils.isNotEmpty(jsonValue), "this argument is required; it must not be null");
        return (T) objectMapper.readValue(jsonValue, valueType);
    }

    /**
     * json数据转化为对象(TypeReference)
     *
     * @param <T>          the type parameter
     * @param jsonStr    the json value
     * @param valueTypeRef the value type ref
     *
     * @return t t
     *
     * @throws IOException the io exception
     */
    public static <T> T parseObject(String jsonStr, TypeReference<T> valueTypeRef) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(jsonValue), "this argument is required; it must not be null");
        T t = null;
        try {
            t = objectMapper.readValue(jsonStr, valueTypeRef);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * json数据转pojo
     *
     * @param jsonStr json字符串
     * @param cls     映射类型
     * @param <T>     推导类型
     * @return 推导类型json对象
     */
    public static <T> T parseObject(String jsonStr, Class<T> cls) {
        T object = null;
        try {
            object = objectMapper.readValue(jsonStr, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * json数据转PojoList
     *
     * @param jsonStr json数据
     * @param cls     类型
     * @param <T>     推导类型
     * @return pojoList
     */
    public static <T> List<T> parseJson2List(String jsonStr, Class<T> cls) {
        List<T> pojoList = null;
        try {
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, cls);
            pojoList = objectMapper.readValue(jsonStr, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pojoList;
    }

    /**
     * json转listMap
     *
     * @param jsonArray jsonArray字符串
     * @return Listmap对象
     */
    public static <T> List<Map<String, T>> parseJson2ListMap(String jsonArray) {
        List<Map<String, T>> convertedListMap = null;
        try {
            convertedListMap = objectMapper.readValue(jsonArray, new TypeReference<List<Map<String, T>>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertedListMap;
    }



    /**
     * 将对象转化为json数据(时间转换格式： "yyyy-MM-dd HH:mm:ss")
     *
     * @param obj the obj
     *
     * @return string string
     *
     * @throws IOException the io exception
     */
    public static String toJsonStringPretty(Object obj) throws IOException {
        Preconditions.checkArgument(obj != null, "this argument is required; it must not be null");
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * json数据转化为对象(时间转换格式： "yyyy-MM-dd HH:mm:ss")
     * User u = JacksonUtil.parseJsonWithFormat(jsonValue, User.class);
     * User[] arr = JacksonUtil.parseJsonWithFormat(jsonValue, User[].class);
     *
     * @param <T>       the type parameter
     * @param jsonValue the json value
     * @param valueType the value type
     *
     * @return t t
     *
     * @throws IOException the io exception
     */
    public static <T> T parseJsonWithFormat(String jsonValue, Class<T> valueType) throws IOException {
        Preconditions.checkArgument(StringUtils.isNotEmpty(jsonValue), "this argument is required; it must not be null");
        return objectMapper.readValue(jsonValue, valueType);
    }

    /**
     * json数据转化为对象(JavaType)
     *
     * @param <T>       the type parameter
     * @param jsonValue the json value
     * @param valueType the value type
     *
     * @return t t
     *
     * @throws IOException the io exception
     */
    public static <T> T parseJsonWithFormat(String jsonValue, JavaType valueType) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(jsonValue), "this argument is required; it must not be null");
        return (T) objectMapper.readValue(jsonValue, valueType);
    }

    /**
     * json数据转化为对象(TypeReference)
     */
    public static <T> T parseJsonWithFormat(String jsonValue, TypeReference<T> valueTypeRef) throws IOException {
        Preconditions.checkArgument(StringUtils.isNotEmpty(jsonValue), "jsonValue is not null");
        return (T) objectMapper.readValue(jsonValue, valueTypeRef);
    }

}
