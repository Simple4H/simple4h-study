package com.simple4h.demo.config;

import com.alibaba.fastjson2.TypeReference;
import com.simple4h.demo.vo.EmailVO;

import java.util.List;

/**
 * EmailHandler
 *
 * @author Simple4H
 */
public class EmailHandler extends ListTypeHandler<EmailVO> {


    @Override
    protected TypeReference<List<EmailVO>> specificType() {
        return new TypeReference<>() {
        };
    }
}
