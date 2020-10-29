package com.simple4h.sample.service.impl;

import com.simple4h.sample.service.ITest2Service;
import com.simple4h.sample.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author Create By Simple4H
 * date 2020-10-28 17:34
 */
@Service("iTestService")
public class TestServiceImpl implements ITestService {

    @Autowired
    private ITest2Service iTest2Service;

    @Override
    public String appendStr(String string) {
        return iTest2Service.append2Str() + string + " Simple4H";
    }
}
