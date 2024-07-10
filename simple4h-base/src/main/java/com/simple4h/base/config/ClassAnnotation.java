package com.simple4h.base.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 类
 *
 * @author Simple4H
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassAnnotation {

    String value();
}
