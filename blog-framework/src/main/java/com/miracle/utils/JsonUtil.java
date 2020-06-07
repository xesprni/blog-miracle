package com.miracle.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Miracle
 * @date 11:26 2020/6/7
 */
@Slf4j
public class JsonUtil {
    /**
     * Mapper
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 标准日期 格式化
     */
    public static final String STAND_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final TypeReference<?> MAP_TYPE = new JsonUtil.MapTypeReference<>();

    private static final TypeReference<?> LIST_TYPE = new JsonUtil.ListTypeReference<>();

    private static class MapTypeReference<T> extends TypeReference<Map<String, T>> {
    };

    private static class ListTypeReference<T> extends TypeReference<List<T>> {
    };

    static {
        //对象全部字段
        MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        //取消默认转timestamp形式
        MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //忽略空bean转json错误
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //统一设置日期格式
        MAPPER.setDateFormat(new SimpleDateFormat(STAND_DATE_FORMAT));
        //忽略json串存在属性class不存在错误
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * bean转JsonString
     * <p>
     * 如果存在日期格式 默认采用 "yyyy-MM-dd HH:mm:ss" format
     * 如需自定义日期格式,请在bean上使用注解{@link com.fasterxml.jackson.annotation.JsonFormat} ex '@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")'
     * <p>
     * 默认忽略空bean异常以及属性不对称异常,默认序列化全部字段,如需忽略,请使用 {@link com.fasterxml.jackson.annotation.JsonIgnore}注解
     *
     * @param bean 转换对象
     * @param <T>  对象泛型
     * @return String
     */
    public static <T> String bean2JsonString(T bean) {
        if (Objects.isNull(bean)) {
            return null;
        }
        try {
            return bean instanceof String ? (String) bean : MAPPER.writeValueAsString(bean);
        } catch (Exception e) {
            log.error("bean2JsonString error {}", bean, e);
            return null;
        }
    }

    /**
     * bean转JsonString(格式化字符串)
     * <p>
     * 如果存在日期格式 默认采用 "yyyy-MM-dd HH:mm:ss" format
     * 如需自定义日期格式,请在bean上使用注解{@link com.fasterxml.jackson.annotation.JsonFormat} 示例 '@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")'
     * <p>
     * 默认忽略空bean异常以及属性不对称异常,默认序列化全部字段,如需忽略,请使用 {@link com.fasterxml.jackson.annotation.JsonIgnore}注解
     *
     * @param bean 转换对象
     * @param <T>  对象泛型
     * @return String
     */
    public static <T> String bean2JsonStringPretty(T bean) {
        if (Objects.isNull(bean)) {
            return null;
        }
        try {
            return bean instanceof String ? (String) bean : MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(bean);
        } catch (Exception e) {
            log.error("bean2JsonStringPretty error {}", bean, e);
            return null;
        }
    }

    /**
     * String转JavaBean
     *
     * @param jsonStr 待转换字符串
     * @param clazz   转换对象
     * @param <T>     java bean
     * @return java bean
     */
    @SuppressWarnings("unchecked")
    public static <T> T string2Bean(String jsonStr, Class<T> clazz) {
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                return clazz.equals(String.class) ? (T) jsonStr : MAPPER.readValue(jsonStr, clazz);
            } catch (Exception e) {
                log.error("string2Bean error {}", jsonStr, e);
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * json转map
     *
     * @param json json
     * @return map
     */
    @SuppressWarnings("unchecked")
    public static <T> Map<String, T> string2Map(String json) {
        if (StringUtils.isBlank(json))
            return null;
        try {
            return (Map<String, T>) MAPPER.readValue(json, MAP_TYPE);
        } catch (Exception e) {
            log.error("string2Map error {}", json, e);
            return null;
        }
    }

    /**
     * json转list
     *
     * @param json json
     * @return list
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> string2List(String json) {
        if (StringUtils.isBlank(json))
            return null;
        try {
            return (List<T>) MAPPER.readValue(json, LIST_TYPE);
        } catch (Exception e) {
            log.error("string2List error {}", json, e);
            return null;
        }
    }
}
