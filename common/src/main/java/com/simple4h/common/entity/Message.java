package com.simple4h.common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * author Create By Simple4H
 * date 2020-09-25 12:03
 */
@Getter
@Setter
@ToString
public class Message {

    private Long taskId;

    private String message;

    private LocalDateTime sendTime;
}
