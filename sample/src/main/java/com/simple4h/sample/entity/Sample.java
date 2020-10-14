package com.simple4h.sample.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * author Create By Simple4H
 * date 2020-09-25 17:13
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@EqualsAndHashCode
public class Sample {

    private Integer id;

    private String name;

    private String password;

    private Integer age;

    private String sex;

    public Sample(Integer id, String name, String password, Integer age, String sex) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.sex = sex;
    }
}
