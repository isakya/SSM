package com.izumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *      ��ѯ���е��û���Ϣ --> /user --> get
 *      ����id��ѯ�û���Ϣ --> /user/1 --> get
 *      ����û���Ϣ --> /user --> post
 *      �޸��û���Ϣ --> /user --> put
 *      ɾ���û���Ϣ --> /user/1 --> delete
 *
 *
 *      ע�⣺�����Ŀǰֻ�ܷ���get��post����
 *          ��Ҫ����put��delete������Ҫ��web.xml������һ��������HiddenHttpMethodFilter
 *          �����˹�����֮�󣬷��͵�����Ҫ�����������������ܽ�����ʽת��Ϊput��delete
 *              1����ǰ�������Ϊpost
 *              2����ǰ������봫��������� _method�� _method��ֵ�������յ�����ʽ
 */

@Controller
public class TestRestController {
    // @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public String getAllUser() {
        System.out.println("��ѯ���е��û���Ϣ--> /user --> get");
        return "success";
    }

    // @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer id) {
        System.out.println("����id��ѯ�û���Ϣ--> /user/ "+ id +" --> get");
        return "success";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping("/user")
    public String insertUser() {
        System.out.println("����û���Ϣ --> /user --> post");
        return "success";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping("/user")
    public String updateUser() {
        System.out.println("�޸��û���Ϣ --> /user --> put");
        return "success";
    }

    // @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        System.out.println("ɾ���û���Ϣ --> /user/ "+id+" --> delete");
        return "success";
    }

}
