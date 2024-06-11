package com.simple4h.demo.service.impl;

import com.simple4h.demo.service.ITestMultiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 实现1
 *
 * @author Simple4H
 */
@Service
@Slf4j
public class OneTestServiceImpl implements ITestMultiService {

    @Override
    public void execute() {
        log.info("OneTestServiceImpl execute");
    }
}
