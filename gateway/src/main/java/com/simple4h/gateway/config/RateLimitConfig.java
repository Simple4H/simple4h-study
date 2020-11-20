package com.simple4h.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * 限流配置类
 *
 * @author Simple4H
 */
@Configuration
public class RateLimitConfig {

    /**
     * 接口限流：根据请求路径限流
     *
     * @return KeyResolver
     */
    @Bean
    @Primary
    public KeyResolver pathKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest()
                .getPath()
                .toString());
    }

    /**
     * 根据请求IP限流
     *
     * @return KeyResolver
     */
    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(
                Objects.requireNonNull(exchange.getRequest()
                        .getRemoteAddress())
                        .getHostName()
        );
    }

    /**
     * 根据请求参数中的userId进行限流
     * 请求地址写法：http://localhost:8000/demo-service/demo?userId=lisi
     *
     * @return KeyResolver
     */
    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(
                Objects.requireNonNull(exchange.getRequest()
                        .getQueryParams()
                        .getFirst("userId"))
        );
    }
}
