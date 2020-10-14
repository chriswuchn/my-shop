package com.chris.my.shop.web.admin.service;

import com.chris.my.shop.web.domain.TbContentCategory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TbContentCategoryService {
    public List<TbContentCategory> selectAll();
}
