package com.chris.my.shop.web.admin.web.controller;

import com.chris.my.shop.web.admin.service.TbContentService;
import com.chris.my.shop.web.domain.TbContent;
import com.chris.my.shop.web.domain.TbUser;
import dto.BaseResult;
import dto.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value="content")
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent=null;
        if(id!=null){
            tbContent=tbContentService.getById(id);
        }else{
            tbContent=new TbContent();
        }
        return tbContent;
    }


    /**
     * 跳转到内容列表页
     * @return
     */
    @RequestMapping(value="list",method= RequestMethod.GET)
    public String list(){
//        List<TbUser> tbUsers = tbUserService.selectAll();
//        model.addAttribute("tbUsers",tbUsers);
        return "content_list";
    }

    /**
     * 跳转内容表单页
     * @return
     */
    @RequestMapping(value="form",method = RequestMethod.GET)
    public String form(Model model){
        return "content_form";
    }

    @RequestMapping(value="save",method = RequestMethod.POST)
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes){
        System.out.println("tbContent:"+tbContent);
        BaseResult baseResult = tbContentService.save(tbContent);
        if(baseResult.getStatus()==200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/content/list";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "/content_form";
        }
    }

    @RequestMapping(value="search",method=RequestMethod.POST)
//    public String search(TbUser tbUser, Model model){
    public String search(TbUser tbUser){
        System.out.println(tbUser);
//        PageInfo<TbUser> pageInfo=new PageInfo<>();
//        List<TbUser> tbUsers = tbUserService.search(tbUser);
//        return tbUserService.search();
        return "content_list";
    }

    /**
     * 删除内容信息
     * @param ids
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult delete(String ids){
        BaseResult baseResult=null;
        if(StringUtils.isNotBlank(ids)){
            String[] idArray=ids.split(",");;
            tbContentService.deleteMutil(idArray);
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
    public PageInfo<TbContent> page(HttpServletRequest request, TbContent tbContent){
        Map<String,Object> result=new HashMap();
        String strdraw=request.getParameter("draw");
        String strstart=request.getParameter("start");
        String strlength=request.getParameter("length");
        int draw=strdraw==null?0:Integer.parseInt(strdraw);
        int start=strstart==null?0:Integer.parseInt(strstart);
        int length=strlength==null?0:Integer.parseInt(strlength);
        return tbContentService.page(start,length,draw,tbContent);
    }

    /**
     * 显示内容详情
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(){
        return "user_detail";
    }

}
