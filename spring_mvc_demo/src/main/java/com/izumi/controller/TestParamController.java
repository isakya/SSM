package com.izumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *  1、通过servletAPI获取
 *      只需要在控制器方法的形参位置设置HttpServletRequest类型的形参，
 *      就可以在控制器方法中使用request来获取请求参数与
 */

@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String  getParamByServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }
}
