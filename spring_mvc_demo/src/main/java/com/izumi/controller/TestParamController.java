package com.izumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 1��ͨ��servletAPI��ȡ
 * ֻ��Ҫ�ڿ������������β�λ������HttpServletRequest���͵��βΣ�
 * �Ϳ����ڿ�����������ʹ��request����ȡ���������
 * <p>
 * 2��ͨ���������������βλ�ȡ�������
 * ֻ��Ҫ�ڿ������������β�λ�ã�����һ���βΣ��βε����ֺ��������������һ�¼���
 *
 * 3��@RequestParam: ����������Ϳ������������βΰ�
 *    @RequestParamע����������ԣ� value��required��defaultValue
 *    value: ���ú��βΰ󶨵��������������
 *    required: �����Ƿ���봫��value����Ӧ�����������Ĭ��Ϊtrue����ʾvalue����Ӧ������������봫�䣬���򱨴�
 *    defaultValue�����õ�û�д���value����Ӧ���������ʱ��Ϊ�β����õ�Ĭ��ֵ����ʱ��required����ֵ�޹�
 *
 * 4��@RequestHeader: ������ͷ��Ϣ�Ϳ������������βΰ�
 * 5��@RequestValue: ��cookie���ݺͿ������������βΰ�
 */

@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName", required = false, defaultValue = "hello") String username,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jsessionId
    ) {
        System.out.println("jsessionId:" + jsessionId);
        System.out.println(username + " " + password);
        System.out.println(referer);
        return "success";
    }
}
