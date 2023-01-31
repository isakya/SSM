package com.izumi.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  拦截器的三个方法：
 *      preHandle(): 在控制器方法执行之前执行，其返回值表示对控制器方法的拦截或放行
 *      postHandle(): 在控制器方法执行之后执行
 *      afterCompletion(): 在控制器方法执行之后，且渲染视图完毕之后执行
 *
 *  多个拦截器的执行顺序
 */

@Component
public class Secondinterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Secondinterceptor-->preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Secondinterceptor-->postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("Secondinterceptor-->afterCompletion");

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
