package com.chris.my.shop.web.admin.dao;

import com.chris.my.shop.web.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentCategoryDao {
    /**
     * 查询所有内容
     * @return
     */
    public List<TbContentCategory> selectAll();

    /**
     * 根据父级节点ID查询所有子节点
     * @param pid
     * @return
     */
    List<TbContentCategory>selectByPid(Long pid);

    public TbContentCategory getById(Long id);

}
