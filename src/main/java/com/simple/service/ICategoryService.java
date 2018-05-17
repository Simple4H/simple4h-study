package com.simple.service;

import com.simple.common.ServerResponse;
import com.simple.pojo.Category;

import java.util.List;

/**
 * Create by S I M P L E on 2018/05/16 14:28:34
 */
public interface ICategoryService {

    ServerResponse<List<Category>> getCategoryList();

    ServerResponse getAllList(Integer pageNum, Integer pageSize);
}
