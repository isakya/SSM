package com.izumi.controller;

import com.izumi.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *          1��@RequestBody: ���������е����ݺͿ������������βν��а�
 *          2��ʹ��@RequestBodyע�⽫json��ʽ���������ת��Ϊjava����
 *              a> ����jackson������
 *              b> ��SpringMVC�������ļ������� <mvc:annotation-driven />
 *              c> �ڴ�������Ŀ������������β�λ�ã�ֱ������json��ʽ���������Ҫת����java���͵��βΣ�ʹ��@RequestBodyע���ʶ����
 *
 *
 */

@Controller
public class TestAjaxController {
    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("requestBody:"+requestBody);
        System.out.println("id:" + id);
        response.getWriter().write("hello, axios");
    }

    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("hello axios");
    }
}
