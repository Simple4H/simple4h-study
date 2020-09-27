package com.simple4h.common.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * author Create By Simple4H
 * date 2020-09-25 12:03
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
public class Message {

    private Long taskId;

    private String message;

    private LocalDateTime sendTime;
}
