package com.zh.springboot.demo.controller.config.interceptor;

import com.zh.springboot.demo.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆检查拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 该方法在控制器方法调用前执行,默认拦截控制器和静态资源请求
     * 当方法返回true，验证通过
     * 当方法返回法false，验证失败，就不会执行/调用控制器方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
     /*   User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            //跳转登陆页面
            return false;
        } else {
            return true;
        }*/
        System.out.println("当前请求："+request.getRequestURI());
        return true;
    }

    /*@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }*/
}
