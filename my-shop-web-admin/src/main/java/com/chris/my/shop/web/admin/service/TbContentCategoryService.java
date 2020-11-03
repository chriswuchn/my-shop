package com.chris.my.shop.web.admin.service;

import com.chris.my.shop.web.domain.TbContent;
import com.chris.my.shop.web.domain.TbContentCategory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

public interface TbContentCategoryService {
    public List<TbContentCategory> selectAll();
    public TbContentCategory getById(Long id);
    List<TbContentCategory> selectByPid(Long pid);
}
