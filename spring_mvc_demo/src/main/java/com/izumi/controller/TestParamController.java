package com.izumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *  1��ͨ��servletAPI��ȡ
 *      ֻ��Ҫ�ڿ������������β�λ������HttpServletRequest���͵��βΣ�
 *      �Ϳ����ڿ�����������ʹ��request����ȡ���������
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
