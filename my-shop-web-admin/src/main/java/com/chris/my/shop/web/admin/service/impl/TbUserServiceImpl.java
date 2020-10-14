package com.chris.my.shop.web.admin.service.impl;

import com.chris.my.shop.web.admin.dao.TbUserDao;
import com.chris.my.shop.web.admin.service.TbUserService;
import com.chris.my.shop.web.domain.TbUser;
import dto.BaseResult;
import dto.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import utils.RegexUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserDao tbUserDao;
    @Override
    public List<TbUser> selectAll() {
        List<TbUser> tbUsers = tbUserDao.selectAll();
        return tbUsers;
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        BaseResult baseResult= checkTbUser(tbUser);
        System.out.println(baseResult);
        if(baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            tbUser.setUpdated(new Date());
            if(tbUser.getId()==null){
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }
            else
                tbUserDao.update(tbUser);
            baseResult.setMessage("保存用户信息成功");
        }
        return baseResult;
    }

    @Override
    public void delete(long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById(long id) {
        return tbUserDao.getById(id);
    }

    public void update(TbUser tbUser){
        tbUserDao.update(tbUser);
    }


    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser= tbUserDao.getByEmail(email);
        if(tbUser!=null){
            String s = DigestUtils.md5DigestAsHex(password.getBytes());
            return s.equals(tbUser.getPassword())==true?tbUser:null;
        }
        return null;
    }

    /**
     * 用户信息的有效性验证
     * @param tbUser
     */
    private BaseResult checkTbUser(TbUser tbUser){
        BaseResult baseResult=BaseResult.success();
        //非空验证
        if(StringUtils.isBlank(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱不能为空,请重新输入");
        }else if(!RegexUtils.checkEmail(tbUser.getEmail())){
            baseResult = BaseResult.fail("邮箱格式不正确，请重新输入");
        }else if(StringUtils.isBlank(tbUser.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空,请重新输入");
        }else if(StringUtils.isBlank(tbUser.getUsername())){
            baseResult = BaseResult.fail("姓名不能为空,请重新输入");
        }else if(StringUtils.isBlank(tbUser.getPhone())){
            baseResult =BaseResult.fail("手机号不能为空,请重新输入");
        }else if(!RegexUtils.checkPhone(tbUser.getPhone())){
            baseResult=BaseResult.fail("手机号格式不正确,请重新输入");
        }
        return baseResult;
    }


    @Override
    public List<TbUser> search(TbUser tbUser) {
        return tbUserDao.search(tbUser);
    }

    @Override
    public void deleteMutil(String[] ids){
        tbUserDao.deleteMutil(ids);
    }

    @Override
    public PageInfo<TbUser> page(int start, int length,int draw,TbUser tbUser) {
        PageInfo<TbUser> pageInfo=new PageInfo<>();
        Map<String,Object> params=new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("tbUser",tbUser);
        List<TbUser> tbUsers=tbUserDao.page(params);
        System.out.println(tbUsers.size());
        pageInfo.setData(tbUsers);
        pageInfo.setDraw(draw);
        int count=tbUserDao.count(tbUser);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        return pageInfo;
    }

    @Override
    public Integer count(TbUser tbUser){
        return tbUserDao.count(tbUser);
    }
}

