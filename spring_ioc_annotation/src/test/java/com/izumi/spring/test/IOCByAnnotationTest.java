package com.izumi.spring.test;

import com.izumi.spring.controller.UserController;
import com.izumi.spring.dao.UserDao;
import com.izumi.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {
    /***
     *  @Component�������ʶΪ��ͨ���
     *  @Controller�������ʶΪ���Ʋ����
     *  @Service�������ʶΪҵ������
     *  @Repository�������ʶΪ�־ò����
     *
     *
     *  ͨ��ע��+ɨ�������õ�id��Ĭ��ֵΪ���С�շ壬����������ĸΪСд�Ľ��
     *  ����ͨ����ʶ�����ע���value����ֵ����bean���Զ���id
     */
    @Test
    public void test() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean("controller",UserController.class);
        System.out.println(userController);
        UserService userService = ioc.getBean("userServiceImpl" ,UserService.class);
        System.out.println(userService);
        UserDao userDao = ioc.getBean("userDaoImpl",UserDao.class);
        System.out.println(userDao);
    }
}
