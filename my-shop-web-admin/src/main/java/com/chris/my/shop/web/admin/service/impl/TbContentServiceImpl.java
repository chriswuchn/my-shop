package com.chris.my.shop.web.admin.service.impl;


import com.chris.my.shop.web.admin.dao.TbContentDao;
import com.chris.my.shop.web.admin.service.TbContentService;
import com.chris.my.shop.web.domain.TbContent;
import com.chris.my.shop.web.domain.TbUser;
import dto.BaseResult;
import dto.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;
import utils.RegexUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;

    public List<TbContent> selectAll(){
        return tbContentDao.selectAll();
    }

    @Override
    public BaseResult save(TbContent tbContent) {
        BaseResult baseResult= checkTbContent(tbContent);
        System.out.println(baseResult);
        if(baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            tbContent.setUpdated(new Date());
            if(tbContent.getId()==null){
                tbContent.setCreated(new Date());
                tbContentDao.insert(tbContent);
            }
            else
                tbContentDao.update(tbContent);
            baseResult.setMessage("保存用户信息成功");
        }
        return baseResult;
    }

    @Override
    public void delete(Long id) {
        tbContentDao.delete(id);
    }

    @Override
    public TbContent getById(Long id) {
        return tbContentDao.getById(id);
    }

    @Override
    public List<TbContent> search(TbContent tbContent) {
        return tbContentDao.search(tbContent);
    }

    @Override
    public void deleteMutil(String[] ids) {
        tbContentDao.deleteMutil(ids);
    }

    @Override
    public PageInfo<TbContent> page(int start, int length,int draw,TbContent tbContent) {
        Map<String,Object> params=new HashMap<String,Object>();
        PageInfo<TbContent> pageInfo=new PageInfo<>();
        params.put("start",start);
        params.put("length",length);
        params.put("tbContent",tbContent);
        List<TbContent> tbContents=tbContentDao.page(params);
        pageInfo.setData(tbContents);
        pageInfo.setDraw(draw);
        int count=tbContentDao.count(tbContent);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        return pageInfo;
    }

    @Override
    public Integer count(TbContent tbContent) {
        return tbContentDao.count(tbContent);
    }

    /**
     * 用户信息的有效性验证
     * @param tbContent
     */
    private BaseResult checkTbContent(TbContent tbContent){
        BaseResult baseResult=BaseResult.success();
        //非空验证
        if(tbContent.getCategoryId()!=null) {
            baseResult = BaseResult.fail("内容的所属分类不能为空，请重新输入");
        }
//        }else if(!RegexUtils.checkEmail(tbContent.title())){
//            baseResult = BaseResult.fail("邮箱格式不正确，请重新输入");
//        }else if(!RegexUtils.checkEmail(tbContent.getEmail())){
//            baseResult = BaseResult.fail("邮箱格式不正确，请重新输入");
//        }else if(!RegexUtils.checkEmail(tbContent.getEmail())){
//            baseResult = BaseResult.fail("邮箱格式不正确，请重新输入");
//        }else if(!RegexUtils.checkEmail(tbContent.getEmail())){
//            baseResult = BaseResult.fail("邮箱格式不正确，请重新输入");
//        }else if(!RegexUtils.checkEmail(tbContent.getEmail())){
//            baseResult = BaseResult.fail("邮箱格式不正确，请重新输入");
//        }else if(StringUtils.isBlank(tbContent.getPassword())) {
//            baseResult = BaseResult.fail("密码不能为空,请重新输入");
//        }else if(StringUtils.isBlank(tbContent.getUsername())){
//            baseResult = BaseResult.fail("姓名不能为空,请重新输入");
//        }else if(StringUtils.isBlank(tbContent.getPhone())){
//            baseResult =BaseResult.fail("手机号不能为空,请重新输入");
//        }else if(!RegexUtils.checkPhone(tbContent.getPhone())){
//            baseResult=BaseResult.fail("手机号格式不正确,请重新输入");
//        }
        return baseResult;
    }

}
