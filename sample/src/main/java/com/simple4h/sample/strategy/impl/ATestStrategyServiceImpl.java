package com.simple4h.sample.strategy.impl;

import com.simple4h.sample.strategy.AbstractStrategyTest;
import com.simple4h.sample.strategy.ITestStrategyService;
import org.springframework.stereotype.Service;

/**
 * TODO:
 *
 * @author Simple4H
 */
@Service
public class ATestStrategyServiceImpl extends AbstractStrategyTest {
    @Override
    public Integer type() {
        return 1;
    }

    @Override
    public String sayType() {
        return "A";
    }
}
