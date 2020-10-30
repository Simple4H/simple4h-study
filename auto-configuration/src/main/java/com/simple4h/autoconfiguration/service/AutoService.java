package com.simple4h.autoconfiguration.service;

import com.simple4h.autoconfiguration.config.AutoBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * author Create By Simple4H
 * date 2020-10-30 10:51
 */
public class AutoService {

    @Autowired
    private AutoBean autoBean;

    public String sayWhat() {
        return "Say What? " + autoBean.getWord();
    }
}
