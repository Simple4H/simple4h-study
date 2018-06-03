package com.simple.concurrency.singleton;

/**
 * Create by S I M P L E on 2018/04/24 14:08:21
 * 饿汉模式
 * 单例实例在类装载进行创建
 */
public class SingletonExample2 {

    //私有构造器
    private SingletonExample2() {

    }

    //单例对象
    private static SingletonExample2 singletonExample1 = new SingletonExample2();

    //静态的工厂方法
    public static SingletonExample2 getInstance() {
        return singletonExample1;
    }


}
