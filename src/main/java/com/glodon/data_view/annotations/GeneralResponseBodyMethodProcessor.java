package com.glodon.data_view.annotations;

import java.util.List;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

public class GeneralResponseBodyMethodProcessor extends RequestResponseBodyMethodProcessor {

    public GeneralResponseBodyMethodProcessor(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return (AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), GeneralResponseBody.class)
                || returnType.hasMethodAnnotation(GeneralResponseBody.class));
    }

}
