package com.simple.concurrency.singleton;

/**
 * Create by S I M P L E on 2018/04/24 14:08:21
 * 懒汉模式
 * 单例实例在第一次使用的时候进行创建
 */
public class SingletonExample1 {

    //私有构造器
    private SingletonExample1() {

    }

    //单例对象
    private static SingletonExample1 singletonExample1 = null;

    //静态的工厂方法
    public static SingletonExample1 getInstance() {
        if (singletonExample1 == null) {
            return new SingletonExample1();
        }
        return singletonExample1;
    }


}
