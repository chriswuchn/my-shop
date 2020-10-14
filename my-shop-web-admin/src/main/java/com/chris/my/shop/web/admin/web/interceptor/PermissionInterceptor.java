package com.chris.my.shop.web.admin.web.interceptor;

import com.chris.my.shop.web.domain.TbUser;
import constant.ConstantUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("miemiemie");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("inter4");
        if(modelAndView!=null && modelAndView.getViewName()!=null){
            if(modelAndView.getViewName().endsWith("login")){
                TbUser tbUser=(TbUser)httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
                if(tbUser!=null){
                    System.out.println("heheh");
                    httpServletResponse.sendRedirect("/main");
                }
            }
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

