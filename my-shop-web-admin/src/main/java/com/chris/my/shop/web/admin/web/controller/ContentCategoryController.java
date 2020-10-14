package com.chris.my.shop.web.admin.web.controller;


import com.chris.my.shop.web.admin.service.TbContentCategoryService;
import com.chris.my.shop.web.domain.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 内容管理
 */
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController {

    @Autowired
    private TbContentCategoryService tbContentCategoryService;

    @RequestMapping(value="list",method= RequestMethod.GET)
    public String list(Model model){
        List<TbContentCategory> tbContentCategories=tbContentCategoryService.selectAll();
        model.addAttribute("tbContentCategories",tbContentCategories);
        return "content_category_list";
    }

}

