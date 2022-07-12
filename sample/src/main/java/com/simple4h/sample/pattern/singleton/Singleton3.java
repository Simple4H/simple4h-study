package com.simple4h.sample.pattern.singleton;

/**
 * 单例模式
 * <p>
 * 懒汉式（内部类）
 * </p>
 *
 * @author Simple4H
 */
public class Singleton3 {

    private static class SingletonHolder {
        private static final Singleton3 SINGLETON = new Singleton3();
    }

    public Singleton3 getInstance() {
        return SingletonHolder.SINGLETON;
    }
}
