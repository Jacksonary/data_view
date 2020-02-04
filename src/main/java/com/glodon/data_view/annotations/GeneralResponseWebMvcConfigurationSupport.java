package com.glodon.data_view.annotations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

@Component
public class GeneralResponseWebMvcConfigurationSupport implements InitializingBean {

    @Autowired
    private RequestMappingHandlerAdapter adapter;

    private void decorateHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        for (HandlerMethodReturnValueHandler handler : handlers) {
            if (handler instanceof RequestResponseBodyMethodProcessor) {
                List<HttpMessageConverter<?>> converters = new ArrayList<>();
                converters.add(new GeneralResponseHttpMessageConverter());
                // 把自己的ResponseBody包装类添加到框架中，达到返回Result的效果
                GeneralResponseBodyMethodProcessor decorator = new GeneralResponseBodyMethodProcessor(converters);
                int index = handlers.indexOf(handler);
                handlers.add(index > 1 ? index - 1 : index, decorator);
                break;
            }
        }
    }

    @Override
    public void afterPropertiesSet() {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        assert returnValueHandlers != null;
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(returnValueHandlers);
        decorateHandlers(handlers);
        adapter.setReturnValueHandlers(handlers);
    }

}
