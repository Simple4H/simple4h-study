package com.simple4h.sample.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * 单例模式
 * <p>
 * 懒汉式（双重检查锁）
 * </p>
 *
 * @author Simple4H
 */
public class Singleton2 {

    private static boolean flag = false;

    private static volatile Singleton2 singleton2;

    public Singleton2 getInstance() {
        if (Objects.isNull(singleton2)) {
            synchronized (Singleton2.class) {
                if (Objects.isNull(singleton2)) {
                    return new Singleton2();
                }
            }
        }
        return singleton2;
    }

    private Singleton2() {
        synchronized (this) {
            if (flag) {
                throw new RuntimeException("多实例");
            }
            flag = true;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Singleton2> declaredConstructor = Singleton2.class.getDeclaredConstructor();
        // 取消访问检查
        declaredConstructor.setAccessible(true);
        Singleton2 s1 = declaredConstructor.newInstance();
        Singleton2 s2 = declaredConstructor.newInstance();
        System.out.println(s1 == s2);
    }
}
