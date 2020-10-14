package com.chris.my.shop.web.admin.dao;

import com.chris.my.shop.web.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository     //不用写实现
public interface TbUserDao {
    public List<TbUser> selectAll();
    public void insert(TbUser tbUser);

    /**
     * 根据id
     * @param id
     */
    public void delete(Long id);
    public TbUser getById(Long id);
    public void update(TbUser tbUser);
    public TbUser getByEmail(String email);

    /**
     * 高级搜索
     * @param tbUser
     * @return
     */
    public List<TbUser> search(TbUser tbUser);
    /**
     * 批量删除
     */
    public void deleteMutil(String[] ids);

    /**
     * 分页查询
     * @param params
     * @return
     */
    public List<TbUser> page(Map<String,Object>params);

    /**
     * 获取总记录数
     * @return
     */
    public Integer count(TbUser tbUser);
}
