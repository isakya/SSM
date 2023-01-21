package com.izumi.spring.test;

import com.izumi.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
    /**
     *      �������ڲ��裺
     *          1. ʵ����
     *          2. ����ע��
     *          3. ��ʼ������Ҫͨ��bean��init-method����ָ����ʼ���ķ���
     *          4. IOC�����ر�ʱ���٣���Ҫͨ��bean��destroy-method����ָ�����ٵķ���
     */
    @Test
    public void test() {
        // ConfigurableApplicationContext��ApplicationContext���ӽӿڣ�������չ��ˢ�º͹ر������ķ���
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }
}
