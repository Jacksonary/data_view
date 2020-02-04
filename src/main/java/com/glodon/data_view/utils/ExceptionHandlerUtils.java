package com.glodon.data_view.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 统一的异常处理
 * 
 * @author singo 2016-03-18
 */
public class ExceptionHandlerUtils {

    public static Map<String, Object> resolveException(Exception ex) {
        String code;
        if (ex instanceof IllegalArgumentException) {
            code = "illegal.argument";
        } else {
            // 获取code, message
            code = "system.error";
        }

        String message = ExceptionUtils.getMessage(ex);

        // Json返回
        Map<String, Object> attributes = new LinkedHashMap<String, Object>();
        attributes.put("code", code);
        attributes.put("message", message);
        return attributes;
    }

}
