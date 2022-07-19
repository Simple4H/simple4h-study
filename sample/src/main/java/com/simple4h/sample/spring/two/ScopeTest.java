package com.simple4h.sample.spring.two;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Scope失效
 *
 * @author Simple4H
 */
@Component
public class ScopeTest {

    @Lazy // 方法1，会生成代理对象
    @Autowired
    private ScopeTest2 scopeTest2;

    @Autowired
    private ScopeTest3 scopeTest3;

    // 方法3：使用对象工厂
    @Autowired
    private ObjectFactory<ScopeTest4> scopeTest4;

    // 方法5：通过容器去获取
    @Autowired
    private ApplicationContext context;

    public ScopeTest4 getScopeTest4() {
        return scopeTest4.getObject();
    }

    public ScopeTest5 getScopeTest5() {
        return context.getBean(ScopeTest5.class);
    }
}

@Scope("prototype")
@Component
class ScopeTest2 {

}

@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS) // 方法2
@Component
class ScopeTest3 {

}

@Scope("prototype")
@Component
class ScopeTest4 {

}

@Scope("prototype")
@Component
class ScopeTest5 {

}
