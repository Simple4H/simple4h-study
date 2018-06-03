package com.simple.concurrency.singleton;

/**
 * Create by S I M P L E on 2018/04/24 14:08:21
 * 懒汉模式 -->双重同步单例模式
 * 单例实例在第一次使用的时候进行创建
 */
public class SingletonExample4 {

    //私有构造器
    private SingletonExample4() {

    }

    //单例对象
    private static SingletonExample4 singletonExample1 = null;

    //静态的工厂方法
    public static SingletonExample4 getInstance() {
        if (singletonExample1 == null) {
            synchronized (SingletonExample4.class){
                if (singletonExample1 == null){
                    singletonExample1 = new SingletonExample4();
                }
            }
        }
        return singletonExample1;
    }


}
