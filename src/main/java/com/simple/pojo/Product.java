package com.simple.pojo;

public class Product {
    private Integer productid;

    private String productname;

    private Integer categoryid;

    private String price;

    public Product(Integer productid, String productname, Integer categoryid, String price) {
        this.productid = productid;
        this.productname = productname;
        this.categoryid = categoryid;
        this.price = price;
    }

    public Product() {
        super();
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }
}