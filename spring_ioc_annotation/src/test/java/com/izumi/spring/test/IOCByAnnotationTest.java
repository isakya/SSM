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
     *
     * @Autowired: 实现自动装配的注解
     *      1. @Autowired注解能够标识的位置
     *         a> 标识成员变量上，此时不需要设置成员变量的set方法
     *         b> 标识在set方法上
     *         c> 为当前成员变量赋值的有参构造上
     *
     *      2. @Autowired注解的原理
     *         a> 默认通过byType的方式，在IOC容器中通过类型匹配某个bean为属性赋值
     *         b> 若有多个类型匹配的bean，此时会自动转换为byName的方式实现自动装配的效果
     *            即将要赋值的属性的属性名作为bean的id匹配某个bean为属性赋值
     *         c> 若byType和byName的方式都无法实现自动装配，即IOC容器中有多个类型匹配的bean
     *            且这些bean的id和要赋值的属性的属性名都不一致，此时抛异常！
     *         d> 此时可以在赋值的属性上，添加一个注解@Qualifier("xxx")
     *            通过该注解的value属性值，指定某个bean的id，将这个bean为属性赋值
     *
     *         注意：若IOC容器中没有任何一个类型匹配的bean，此时抛出异常！
     *              在@Autowired注解中有个属性required，默认为true，要求必须完成自动装配
     *              可以将required设置为false，此时能装配就装配，不能装配就使用属性的默认值
     */
    @Test
    public void test() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean("controller",UserController.class);
        // System.out.println(userController);
        // UserService userService = ioc.getBean("userServiceImpl" ,UserService.class);
        // System.out.println(userService);
        // UserDao userDao = ioc.getBean("userDaoImpl",UserDao.class);
        // System.out.println(userDao);

        userController.saveUser();
    }
}
