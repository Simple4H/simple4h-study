package com.simple.concurrency.singleton;

/**
 * Create by S I M P L E on 2018/04/24 14:08:21
 * 懒汉模式
 * 单例实例在第一次使用的时候进行创建
 */
public class SingletonExample3 {

    //私有构造器
    private SingletonExample3() {

    }

    //单例对象
    private static SingletonExample3 singletonExample1 = null;

    //静态的工厂方法
    public synchronized static SingletonExample3 getInstance() {
        if (singletonExample1 == null) {
            return new SingletonExample3();
        }
        return singletonExample1;
    }


}
