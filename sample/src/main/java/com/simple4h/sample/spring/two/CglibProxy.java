package com.simple4h.sample.spring.two;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * CGLib代理
 *
 * @author Simple4H
 */
public class CglibProxy {

    static class Target {
        public void test() {
            System.out.println("test");
        }
    }

    public static void main(String[] args) {

        Target target = new Target();
        Target proxy = (Target) Enhancer.create(Target.class, (MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("前置增强");
            // 使用方法反射调用目标
//            Object invoke = method.invoke(target, args);

            // methodProxy
            // 用法1：可以避免反射调用，内部不使用反射
//            Object invoke = methodProxy.invoke(target, args);

            // 用法2：内部没有使用反射，需要代理
            Object invoke = methodProxy.invokeSuper(o, args);

            System.out.println("后置增强");
            return invoke;
        });
        proxy.test();
    }
}
