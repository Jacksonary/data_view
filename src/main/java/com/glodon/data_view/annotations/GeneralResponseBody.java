package com.glodon.data_view.annotations;

import java.lang.annotation.*;

/**
 * @author liuwg-a
 * @date 2019/11/15 8:56
 * @description
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GeneralResponseBody {
}
