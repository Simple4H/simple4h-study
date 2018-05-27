package com.simple.pojo;

import java.util.Date;

public class Order {
    private Integer id;

    private Date createTime;

    public Order(Integer id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}