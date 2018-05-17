package com.simple.dao;

import com.simple.pojo.Category;

import java.util.List;


public interface CategoryMapper {
    int deleteByPrimaryKey(Integer categoryid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer categoryid);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> getCategoryList();

    List<Category> getAllCategory();
}