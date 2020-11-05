package com.simple4h.gateway.entity;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author Create By Simple4H
 * date 2020-11-05 16:55
 */
@Data
public class PredicateEntity {

    //断言对应的Name
    private String name;

    //断言规则
    private Map<String, String> args = new LinkedHashMap<>();
}
