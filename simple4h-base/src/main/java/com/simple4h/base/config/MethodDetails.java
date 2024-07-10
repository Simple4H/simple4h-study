package com.simple4h.base.config;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * EndPoint
 *
 * @author Simple4H
 */
@Data
@Accessors(chain = true)
public class MethodDetails {

    /**
     * 菜单code
     */
    private String menuCode;

    /**
     * 方法名称
     */
    private String methodDesc;

    /**
     * 端口
     */
    private String endpoint;

    /**
     * 方法请求方式
     */
    private String methodType;
}
