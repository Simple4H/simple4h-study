package com.simple4h.sample.demo2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean
 *
 * @author Simple4H
 */
@Slf4j
public class Test implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;
    private String address;
    private int phone;

    private BeanFactory beanFactory;

    private String beanName;

    public Test() {
        log.info("【第6步】：构造器 调用Test的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        log.info("【第8步】：注入属性 注入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        log.info("【第8步】：注入属性 注入属性address");
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        log.info("【第8步】：注入属性 注入属性phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person [address=" + address + ", name=" + name + ", phone=" + phone + "]";
    }

    // 这是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        log.info("【第10步】：BeanFactoryAware接口 调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = arg0;
    }

    // 这是BeanNameAware接口方法
    @Override
    public void setBeanName(String arg0) {
        log.info("【第9步】：BeanNameAware接口 调用BeanNameAware.setBeanName()");
        this.beanName = arg0;
    }

    // 这是InitializingBean接口方法
    @Override
    public void afterPropertiesSet() {
        log.info("【第12步】：InitializingBean接口 调用InitializingBean.afterPropertiesSet()");
    }

    // 这是DiposibleBean接口方法
    @Override
    public void destroy() throws Exception {
        log.info("【第17步】：DiposibleBean接口 调用DiposibleBean.destory()");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        log.info("【第13步】：init-method 调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
        log.info("【第19步】：destroy-method 调用<bean>的destroy-method属性指定的初始化方法");
    }
}
