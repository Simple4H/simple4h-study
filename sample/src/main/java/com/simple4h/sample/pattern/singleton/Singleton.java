package com.simple4h.sample.pattern.singleton;

/**
 * 单例模式
 * <p>
 * 饿汉式（静态代码块）
 * </p>
 *
 * @author Simple4H
 */
public class Singleton {

    // 私有构造方法
    private Singleton() {
    }

    // 创建对象
    private static final Singleton instance = new Singleton();

    // 提供一个公共访问
    public static Singleton getInstance() {
        return instance;
    }

}
