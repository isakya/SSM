package com.izumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *      ��ѯ���е��û���Ϣ --> /user --> get
 *      ����id��ѯ�û���Ϣ --> /user/1 --> get
 *      ����û���Ϣ --> /user --> post
 *      �޸��û���Ϣ --> /user --> put
 *      ɾ���û���Ϣ --> /user/1 --> delete
 */

@Controller
public class TestRestController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser() {
        System.out.println("��ѯ���е��û���Ϣ--> /user --> get");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id) {
        System.out.println("����id��ѯ�û���Ϣ--> /user/ "+ id +" --> get");
        return "success";
    }

}
