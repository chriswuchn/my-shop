package com.chris.my.shop.web.admin.web.controller;

import com.chris.my.shop.web.admin.service.TbUserService;
import com.chris.my.shop.web.domain.TbUser;
import com.fasterxml.jackson.databind.ser.Serializers;
import dto.BaseResult;
import dto.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="user")
public class TbUserController {
    @Autowired
    TbUserService tbUserService;

    @ModelAttribute
    public TbUser getTbUser(Long id){
        TbUser tbUser=null;
        if(id!=null){
            tbUser=tbUserService.getById(id);
        }else{
            tbUser=new TbUser();
        }
        return tbUser;
    }

    /**
     * 跳转到用户列表页
     * @return
     */
    @RequestMapping(value="list",method= RequestMethod.GET)
    public String list(){
//        List<TbUser> tbUsers = tbUserService.selectAll();
//        model.addAttribute("tbUsers",tbUsers);
        return "user_list";
    }

    /**
     * 跳转用户表单页
     * @return
     */
    @RequestMapping(value="form",method = RequestMethod.GET)
    public String form(Model model){
        return "user_form";
    }

    @RequestMapping(value="save",method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model,RedirectAttributes redirectAttributes){
        System.out.println("tbUser:"+tbUser);
        BaseResult baseResult = tbUserService.save(tbUser);
        if(baseResult.getStatus()==200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "/user_form";
        }
    }

    @RequestMapping(value="search",method=RequestMethod.POST)
//    public String search(TbUser tbUser, Model model){
    public String search(TbUser tbUser){
        System.out.println(tbUser);
//        PageInfo<TbUser> pageInfo=new PageInfo<>();
//        List<TbUser> tbUsers = tbUserService.search(tbUser);
//        return tbUserService.search();
        return "user_list";
    }

    /**
     * 删除用户信息
     * @param ids
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult delete(String ids){
        BaseResult baseResult=null;
        if(StringUtils.isNotBlank(ids)){
            String[] idArray=ids.split(",");;
            tbUserService.deleteMutil(idArray);
            baseResult= BaseResult.success("删除用户成功");
        }else{
            baseResult=BaseResult.fail("删除用户失败");
        }
        return baseResult;
    }




    /**
     * 分页查询
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value="page",method={RequestMethod.GET,RequestMethod.POST})
    public PageInfo<TbUser> page(HttpServletRequest request,TbUser tbUser){
        Map<String,Object> result=new HashMap();
        String strdraw=request.getParameter("draw");
        String strstart=request.getParameter("start");
        String strlength=request.getParameter("length");
        int draw=strdraw==null?0:Integer.parseInt(strdraw);
        int start=strstart==null?0:Integer.parseInt(strstart);
        int length=strlength==null?0:Integer.parseInt(strlength);
        return tbUserService.page(start,length,draw,tbUser);
    }

    /**
     * 显示用户详情
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(){
        return "user_detail";
    }

}

