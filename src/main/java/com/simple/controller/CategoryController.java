package com.simple.controller;

import com.simple.common.ServerResponse;
import com.simple.pojo.Category;
import com.simple.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Create by S I M P L E on 2018/05/16 14:22:54
 */

@Controller
@RequestMapping(value = "/category/")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    // 普通查询
    @RequestMapping(value = "get_list.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<List<Category>> getList() {
        return iCategoryService.getCategoryList();
    }

    // 通过分页插件查询
    @RequestMapping(value = "get_all_list.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getAllList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageNum", defaultValue = "5") int pageSize) {
        return iCategoryService.getAllList(pageNum,pageSize);
    }
}
