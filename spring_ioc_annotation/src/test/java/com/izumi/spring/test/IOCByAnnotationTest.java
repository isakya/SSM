package com.izumi.spring.test;

import com.izumi.spring.controller.UserController;
import com.izumi.spring.dao.UserDao;
import com.izumi.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {
    /***
     *  @Component：将类标识为普通组件
     *  @Controller：将类标识为控制层组件
     *  @Service：将类标识为业务层组件
     *  @Repository：将类标识为持久层组件
     *
     *
     *  通过注解+扫描所配置的id，默认值为类的小驼峰，即类名首字母为小写的结果
     *  可以通过标识组件的注解的value属性值设置bean的自定义id
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
