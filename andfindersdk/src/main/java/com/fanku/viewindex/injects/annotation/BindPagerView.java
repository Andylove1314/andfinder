package com.fanku.viewindex.injects.annotation;

/**
 * 控件 注解
 * Created by fengkun on 16/3/24.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindPagerView {
    int value();
    String tag();
}
