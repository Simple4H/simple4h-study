package com.simple4h.base.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 方法
 *
 * @author Simple4H
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {

    String value();
}
