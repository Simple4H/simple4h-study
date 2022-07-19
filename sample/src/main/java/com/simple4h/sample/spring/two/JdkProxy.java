package com.simple4h.sample.spring.two;

import java.lang.reflect.Proxy;

/**
 * JDK代理
 *
 * @author Simple4H
 */
public class JdkProxy {

    interface Test {
        void test();
    }

    static class Target implements Test {

        @Override
        public void test() {
            System.out.println("test");
        }
    }

    public static void main(String[] args) {
        Target target = new Target();

        // ClassLoader加载类，用来加载运行期间动态生成的字节码
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        Test before = (Test) Proxy.newProxyInstance(classLoader, new Class[]{Test.class}, (proxy, method, args1) -> {
            System.out.println("前置增强");
            Object invoke = method.invoke(target, args);
            System.out.println("后置增强");
            return invoke;
        });
        before.test();
    }
}
