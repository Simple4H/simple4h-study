package com.simple.service.impl;

import com.simple.common.ServerResponse;
import com.simple.dao.OrderMapper;
import com.simple.pojo.Order;
import com.simple.service.IOrderService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Create by S I M P L E on 2018/05/27 12:50:30
 */
@Service("iOrderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    public ServerResponse getCloseOrderList(int hour) {
        Date date = DateUtils.addHours(new Date(), -hour);
        List<Order> orderList = orderMapper.getCloseOrderList(date);
        if (!orderList.isEmpty()){
            return ServerResponse.createBySuccess("查询成功",orderList);
        }
        return ServerResponse.createByErrorMessage("查询失败");

    }
}
