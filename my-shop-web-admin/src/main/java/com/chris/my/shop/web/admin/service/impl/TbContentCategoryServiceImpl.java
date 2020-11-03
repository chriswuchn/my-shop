package com.chris.my.shop.web.admin.service.impl;

import com.chris.my.shop.web.admin.dao.TbContentCategoryDao;
import com.chris.my.shop.web.admin.service.TbContentCategoryService;
import com.chris.my.shop.web.domain.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;


    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }

    public TbContentCategory getById(Long id) {
        return tbContentCategoryDao.getById(id);
    }


    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return tbContentCategoryDao.selectByPid(pid);
    }
}

