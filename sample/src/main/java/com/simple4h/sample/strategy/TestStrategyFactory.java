package com.simple4h.sample.strategy;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * his数据工厂类
 *
 * @author Simple4H
 */
@Component
public class TestStrategyFactory {

    private final List<ITestStrategyService> iTestStrategyServices;

    public TestStrategyFactory(List<ITestStrategyService> iTestStrategyServices) {
        this.iTestStrategyServices = iTestStrategyServices;
    }

    public ITestStrategyService getService(Integer type) {
        return iTestStrategyServices.stream().filter(service -> Objects.equals(service.type(), type)).findFirst().orElseThrow(() -> new RuntimeException("获取类型异常"));
    }
}
