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
     *
     * @Autowired: ʵ���Զ�װ���ע��
     *      1. @Autowiredע���ܹ���ʶ��λ��
     *         a> ��ʶ��Ա�����ϣ���ʱ����Ҫ���ó�Ա������set����
     *         b> ��ʶ��set������
     *         c> Ϊ��ǰ��Ա������ֵ���вι�����
     *
     *      2. @Autowiredע���ԭ��
     *         a> Ĭ��ͨ��byType�ķ�ʽ����IOC������ͨ������ƥ��ĳ��beanΪ���Ը�ֵ
     *         b> ���ж������ƥ���bean����ʱ���Զ�ת��ΪbyName�ķ�ʽʵ���Զ�װ���Ч��
     *            ����Ҫ��ֵ�����Ե���������Ϊbean��idƥ��ĳ��beanΪ���Ը�ֵ
     *         c> ��byType��byName�ķ�ʽ���޷�ʵ���Զ�װ�䣬��IOC�������ж������ƥ���bean
     *            ����Щbean��id��Ҫ��ֵ�����Ե�����������һ�£���ʱ���쳣��
     *         d> ��ʱ�����ڸ�ֵ�������ϣ����һ��ע��@Qualifier("xxx")
     *            ͨ����ע���value����ֵ��ָ��ĳ��bean��id�������beanΪ���Ը�ֵ
     *
     *         ע�⣺��IOC������û���κ�һ������ƥ���bean����ʱ�׳��쳣��
     *              ��@Autowiredע�����и�����required��Ĭ��Ϊtrue��Ҫ���������Զ�װ��
     *              ���Խ�required����Ϊfalse����ʱ��װ���װ�䣬����װ���ʹ�����Ե�Ĭ��ֵ
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
