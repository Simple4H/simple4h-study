package com.simple4h.base.config;

import com.alibaba.fastjson2.JSON;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PathPatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 获取项目所有的EndPoint
 *
 * @author Simple4H
 */
@Component
@Slf4j//
public class EndpointInit {

    @Resource
    private ApplicationContext applicationContext;

    @PostConstruct
    public void printEndpoints() {

        log.info("开始初始化数据");
        // 创建一个List来存储结果
        List<MethodDetails> result = new ArrayList<>();

        // 获取所有RequestMappingHandlerMapping bean
        Map<String, RequestMappingHandlerMapping> mappings = applicationContext.getBeansOfType(RequestMappingHandlerMapping.class);

        for (RequestMappingHandlerMapping mapping : mappings.values()) {
            // 获取所有的handler method
            Map<RequestMappingInfo, HandlerMethod> handlerMethods = mapping.getHandlerMethods();

            for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
                RequestMappingInfo requestMappingInfo = entry.getKey();
                HandlerMethod handlerMethod = entry.getValue();

                // 获取类上的注解
                Class<?> beanType = handlerMethod.getBeanType();
                if (beanType.isAnnotationPresent(ClassAnnotation.class)) {
                    ClassAnnotation classAnnotation = beanType.getAnnotation(ClassAnnotation.class);
                    String classAnnotationValue = classAnnotation.value();

                    // 获取方法上的注解
                    if (handlerMethod.hasMethodAnnotation(MethodAnnotation.class)) {
                        MethodAnnotation methodAnnotation = handlerMethod.getMethodAnnotation(MethodAnnotation.class);
                        if (Objects.isNull(methodAnnotation)) {
                            throw new RuntimeException("接口方法上注解不能为空");
                        }
                        String methodAnnotationValue = methodAnnotation.value();
                        PathPatternsRequestCondition pathPatternsCondition = requestMappingInfo.getPathPatternsCondition();
                        if (Objects.isNull(pathPatternsCondition)) {
                            break;
                        }
                        String endpoint = pathPatternsCondition.toString().replaceAll("[\\[\\]]", "");
                        String methodType = requestMappingInfo.getMethodsCondition().toString().replaceAll("[\\[\\]]", "");
                        // 将方法注解和endpoint信息添加到对应的类注解值的列表中
                        result.add(new MethodDetails()
                                .setMenuCode(classAnnotationValue)
                                .setMethodDesc(methodAnnotationValue)
                                .setEndpoint(endpoint)
                                .setMethodType(methodType));
                    }
                }
            }
        }
        log.info("接口校验初始化数据结束，初始化数据:{}", JSON.toJSONString(result));
    }
}
