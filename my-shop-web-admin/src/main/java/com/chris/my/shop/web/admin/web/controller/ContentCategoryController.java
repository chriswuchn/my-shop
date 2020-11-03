package com.chris.my.shop.web.admin.web.controller;


import com.chris.my.shop.web.admin.service.TbContentCategoryService;
import com.chris.my.shop.web.domain.TbContentCategory;
import com.chris.my.shop.web.domain.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ModelAttribute
    public TbContentCategory getTbContentCategory(Long id){
        TbContentCategory tbContentCategory=null;
        if(id!=null){
            tbContentCategoryService.getById(id);
        }else{
            tbContentCategory=new TbContentCategory();
        }
        return tbContentCategory;
    }

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
     * 模态框中展示树形结构
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "tree/data",method = RequestMethod.POST)
    public List<TbContentCategory> treeData(Long id){
        id=(id==null)?0L:id;
        return tbContentCategoryService.selectByPid(id);

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

