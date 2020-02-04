package com.glodon.data_view.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glodon.data_view.utils.ExceptionHandlerUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @author liuwg-a
 * @date 2019/1/4 21:02
 * @description 全局统一异常处理
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        // Json返回
        MappingJackson2JsonView view = new MappingJackson2JsonView() {
            @Override
            protected Object filterModel(Map<String, Object> model) {
                return model;
            }
        };
        view.setAttributesMap(ExceptionHandlerUtils.resolveException(e));
        return new ModelAndView(view);
    }
}
