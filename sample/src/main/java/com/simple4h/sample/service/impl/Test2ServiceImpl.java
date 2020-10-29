package com.simple4h.sample.service.impl;

import com.simple4h.sample.service.ITest2Service;
import org.springframework.stereotype.Service;

/**
 * author Create By Simple4H
 * date 2020-10-28 17:34
 */
@Service("iTest2Service")
public class Test2ServiceImpl implements ITest2Service {

    @Override
    public String append2Str() {
        return "2-Test ";
    }
}
