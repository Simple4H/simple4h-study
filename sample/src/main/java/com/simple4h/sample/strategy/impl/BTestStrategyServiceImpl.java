package com.simple4h.sample.strategy.impl;

import com.simple4h.sample.strategy.AbstractStrategyTest;
import org.springframework.stereotype.Service;

/**
 * TODO:
 *
 * @author Simple4H
 */
@Service
public class BTestStrategyServiceImpl extends AbstractStrategyTest {
    @Override
    public Integer type() {
        return 2;
    }

    @Override
    public String sayType() {
        return "B";
    }
}
