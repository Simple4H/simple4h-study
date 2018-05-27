package com.simple.service;

import com.simple.common.ServerResponse;

/**
 * Create by S I M P L E on 2018/05/27 12:50:03
 */
public interface IOrderService {

    ServerResponse getCloseOrderList(int hour);
}
