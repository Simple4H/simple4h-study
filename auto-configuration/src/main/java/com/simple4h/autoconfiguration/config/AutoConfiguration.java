package com.simple4h.autoconfiguration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author Create By Simple4H
 * <p>相当于一个普通的 java 配置类,当 AutoService 在类路径的条件下,将 application.yml 的相关的属性字段与该类一一对应，并生成 Bean</p>
 * date 2020-10-30 10:29
 */
@Configuration
@ConditionalOnClass({AutoBean.class})
@EnableConfigurationProperties(AutoProperties.class)
public class AutoConfiguration {

    @Autowired
    private AutoProperties autoProperties;

    @Bean
    // 当容器没有这个 Bean 的时候才创建这个 Bean
    @ConditionalOnMissingBean(AutoBean.class)
    public AutoBean autoService() {
        AutoBean autoBean = new AutoBean();
        autoBean.setWord(autoProperties.getWord());
        return autoBean;
    }
}
