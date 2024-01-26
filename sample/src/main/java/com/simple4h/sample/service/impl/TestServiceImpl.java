package com.simple4h.sample.service.impl;

import com.simple4h.sample.service.ITest2Service;
import com.simple4h.sample.service.ITestService;
import jakarta.annotation.Resource;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;


/**
 * Author Create By Simple4H
 * date 2020-10-28 17:34
 */
@Service("iTestService")
public class TestServiceImpl implements ITestService {

    private final static String BLOOM_FILTER_KEY = "Simple4H";

    @Resource
    private ITest2Service iTest2Service;

    @Resource
    private RedissonClient redissonClient;

    @Override
    public String appendStr(String string) {
        return iTest2Service.append2Str() + string + " Simple4H";
    }

    @Override
    public Boolean bloomFilter(String val) {
        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter(BLOOM_FILTER_KEY);
        bloomFilter.tryInit(10000, 0.1);
        return bloomFilter.add(val);
    }
}
