package com.simple.service.impl;

import com.github.pagehelper.PageHelper;
import com.simple.common.ServerResponse;
import com.simple.dao.CategoryMapper;
import com.simple.pojo.Category;
import com.simple.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by S I M P L E on 2018/05/16 14:29:04
 */
@Service("iTestService")
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public ServerResponse<List<Category>> getCategoryList() {
        List<Category> categoryList = categoryMapper.getCategoryList();
        if (!categoryList.isEmpty()) {
            return ServerResponse.createBySuccess(categoryList);
        }
        return ServerResponse.createByErrorMessage("查询为空");
    }

    public ServerResponse getAllList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> categoryList = categoryMapper.getAllCategory();
        if (!categoryList.isEmpty()) {
//            若想获取详细的分页信息，通过返回PageInfo即可
//            PageInfo<Category> pageResult = new PageInfo<>(categoryList);
//            return ServerResponse.createBySuccess("查询成功", pageResult);
//            如果只想直接分页，则直接返回即可
            return ServerResponse.createBySuccess("查询成功", categoryList);
        }
        return ServerResponse.createByErrorMessage("查询为空");
    }

}
