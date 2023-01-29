package com.izumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
 */

@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName", required = false, defaultValue = "hello") String username,
            String password
    ) {
        System.out.println(username + " " + password);
        return "success";
    }
}
