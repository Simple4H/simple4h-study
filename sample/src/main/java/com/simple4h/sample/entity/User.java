package com.simple4h.sample.entity;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * author Create By Simple4H
 * date 2020-10-29 14:12
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class User extends Sample {

    private String url;

    private String phone;


    public User(Integer id, String name, String password, Integer age, String sex, String url, String phone) {
        super(id, name, password, age, sex);
        this.url = url;
        this.phone = phone;
    }

}
