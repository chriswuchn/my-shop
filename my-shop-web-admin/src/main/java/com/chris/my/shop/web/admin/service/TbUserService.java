package com.chris.my.shop.web.admin.service;


import com.chris.my.shop.web.domain.TbUser;
import dto.BaseResult;
import dto.PageInfo;

import java.util.List;

public interface TbUserService {
    /**
     * 查询全部
     * @return
     */
    public List<TbUser> selectAll();

    /**
     * 保存用户信息
     * @param tbUser
     * @return
     */
    public BaseResult save(TbUser tbUser);

    /**
     * 删除用户信息
     * @param id
     */
    public void delete(long id);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public TbUser getById(long id);
    public void update(TbUser tbUser);
    /*用户登录*/
    public TbUser login(String email,String password);
    public List<TbUser> search(TbUser tbUser);
    public void deleteMutil(String[] ids);
    public PageInfo<TbUser> page(int start, int length,int draw,TbUser tbUser);
    public Integer count(TbUser tbUser);
}
