package com.chris.my.shop.web.admin.service;

import com.chris.my.shop.web.domain.TbContent;
import com.chris.my.shop.web.domain.TbUser;
import dto.BaseResult;
import dto.PageInfo;

import java.util.List;
import java.util.Map;

public interface TbContentService {
    /**
     * 获取全部内容
     * @return
     */
    public List<TbContent> selectAll();

    /**
     * 插入新内容
     * @param tbContent
     */
    public BaseResult save(TbContent tbContent);
    /**
     * 根据id删除记录
     * @param id
     */
    public void delete(Long id);
    public TbContent getById(Long id);

    /**
     * 高级搜索
     * @param tbContent
     * @return
     */
    public List<TbContent> search(TbContent tbContent);
    /**
     * 批量删除
     */
    public void deleteMutil(String[] ids);

    /**
     * 分页查询
     * @param
     * @return
     */
    public PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent);
    /**
     * 获取总记录数
     * @return
     */
    public Integer count(TbContent tbContent);
}
