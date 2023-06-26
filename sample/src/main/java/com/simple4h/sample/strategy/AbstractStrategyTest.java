package com.simple4h.sample.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * TODO:
 *
 * @author Simple4H
 */
@Component
@Slf4j
public abstract class AbstractStrategyTest implements ITestStrategyService {

    public void exec() {
        log.info("type:{}", type());
        log.info("say type:{}", sayType());
    }

}
