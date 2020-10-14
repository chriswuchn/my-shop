package com.chris.my.shop.web.admin.web.interceptor;

import com.chris.my.shop.web.domain.TbUser;
import constant.ConstantUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);

        System.out.println("inter1");
        // 判断用户是否登录
        if (tbUser == null) {
            // 用户未登录，重定向到登录页
            httpServletResponse.sendRedirect("/login");
            return false;

        }
        System.out.println(tbUser);
        // 放行
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // 如果请求来自登录页
        System.out.println("inter3");
        if(modelAndView!=null && modelAndView.getViewName()!=null){
            if (modelAndView.getViewName().endsWith("login")) {
                // 则直接重定向到首页不再显示登录页
                httpServletResponse.sendRedirect("/main");
                return;
            }
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

