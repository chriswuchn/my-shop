package com.chris.my.shop.web.admin.web.controller;


import com.chris.my.shop.web.admin.service.TbContentCategoryService;
import com.chris.my.shop.web.domain.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
        List<TbContentCategory> targetList=new ArrayList<>();
        List<TbContentCategory> sourceList=tbContentCategoryService.selectAll();
        //排序
        sortList(sourceList,targetList,0L);

        model.addAttribute("tbContentCategories",targetList);
        return "content_category_list";
    }

    /**
     * 排序
     * @param sourceList 数据源
     * @param targetList 目标数据
     * @param parentId   父节点ID
     */
    private void sortList(List<TbContentCategory> sourceList,List<TbContentCategory> targetList,Long parentId) {
        for (TbContentCategory tbContentCategory : sourceList) {
            if (tbContentCategory.getParentId().equals(parentId)) {
                targetList.add(tbContentCategory);
                //判断有没有子节点
                if (tbContentCategory.getIsParent()) {
                    for (TbContentCategory contentCategory : sourceList) {
                        if (contentCategory.getParentId().equals(tbContentCategory.getId())) {
                            sortList(sourceList, targetList, tbContentCategory.getId());
                            break;
                        }
                    }
                }
            }
        }
    }

}

