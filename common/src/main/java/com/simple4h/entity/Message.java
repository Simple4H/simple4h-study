package com.simple4h.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * author Create By Simple4H
 * date 2020-09-25 12:03
 */
@Getter
@Setter
public class Message {

    private Long taskId;

    private String message;

    private Date sendTime;
}
