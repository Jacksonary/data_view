/**
 * 
 */
package com.glodon.data_view.annotations;

import static com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.glodon.data_view.bean.GeneralResponse;
import com.glodon.data_view.bean.PagedList;

/**
 * json转换器
 * 
 * @author liuj-s
 */
public class GeneralResponseHttpMessageConverter extends FastJsonHttpMessageConverter {

    private static final String RESPONSE_HEADER_KEY = "X-Pagination-Total-Count";

    public GeneralResponseHttpMessageConverter() {
        super();
        setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.TEXT_HTML));
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(WriteMapNullValue, QuoteFieldNames);
        super.setFastJsonConfig(fastJsonConfig);
    }

    @Override
    public void write(Object obj, Type type, MediaType contentType,
                      HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        Object result = obj;

        if (obj != null && !(obj instanceof GeneralResponse<?>)) {
            GeneralResponse<Object> generalResponse = new GeneralResponse<>();
            if (obj instanceof PagedList<?>) {
                PagedList<?> pagedList = (PagedList<?>) obj;
                generalResponse.setData(pagedList.getList());
                outputMessage.getHeaders().add(RESPONSE_HEADER_KEY,
                                               String.valueOf(pagedList.getPage().getTotalCount()));
                // 修复跨域问题
                outputMessage.getHeaders().setAccessControlExposeHeaders(Arrays.asList(RESPONSE_HEADER_KEY));
            } else {
                generalResponse.setData(obj);
            }
            result = generalResponse;
        } else if (obj == null) {
            result = new GeneralResponse<>(obj);
        }
        super.write(result, contentType, outputMessage);
    }
}
