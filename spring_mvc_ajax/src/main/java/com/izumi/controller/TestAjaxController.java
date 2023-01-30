package com.izumi.controller;

import com.izumi.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 *          1��@RequestBody: ���������е����ݺͿ������������βν��а�
 *          2��ʹ��@RequestBodyע�⽫json��ʽ���������ת��Ϊjava����
 *              a> ����jackson������
 *              b> ��SpringMVC�������ļ������� <mvc:annotation-driven />
 *              c> �ڴ�������Ŀ������������β�λ�ã�ֱ������json��ʽ���������Ҫת����java���͵��βΣ�ʹ��@RequestBodyע���ʶ����
 *
 *          3��@ResponseBody: ������ʶ�Ŀ����������ķ���ֵ��Ϊ��Ӧ���ĵ���Ӧ����Ӧ�������
 *          4��ʹ��@ResponseBodyע����Ӧ�����json��ʽ������
 *              a> ����jackson������
 *              b> ��SpringMVC�������ļ�������<mvc:annotation-driven />
 *              c> ����Ҫת��Ϊjson�ַ�����java����ֱ����Ϊ�����������ķ���ֵ��ʹ��@ResponseBodyע���ʶ�����������Ϳ��Խ�java����ֱ��ת��Ϊjson�ַ���������Ӧ�������
 *
 *
 *          ���õ�java����תΪjson�Ľ����
 *              ʵ����--> json����
 *              map--> json����
 *              list--> json����
 *
 */

@Controller
// @RestController �൱�� @Controller + @ResponseBody
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


    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "success";
    }

    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public List<User> testResponseBodyJson() {
        User user1 = new User(1001, "admin", "123456", 20,"��");
        User user2 = new User(1001, "admin", "123456", 20,"��");
        User user3 = new User(1001, "admin", "123456", 20,"��");
        List<User> list = Arrays.asList(user1, user2, user3);
        return list;
    }

    // public User testResponseBodyJson() {
    //     User user = new User(1001, "admin", "123456", 20,"��");
    //     return user;
    // }
}
