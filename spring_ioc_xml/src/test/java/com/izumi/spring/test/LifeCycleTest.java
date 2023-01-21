package com.izumi.spring.test;

import com.izumi.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
    /**
     *      �������ڲ��裺
     *          1. ʵ����
     *          2. ����ע��
     *          3. ���ô�������postProcessBeforeInitialization
     *          4. ��ʼ������Ҫͨ��bean��init-method����ָ����ʼ���ķ���
     *          5. ���ô�������postProcessAfterInitialization
     *          6. IOC�����ر�ʱ���٣���Ҫͨ��bean��destroy-method����ָ�����ٵķ���
     *
     *          ע�⣺
     *              ��bean��������Ϊ����ʱ���������ڵ�ǰ����������ڻ�ȡIOC����ʱִ��
     *              ��bean��������Ϊ����ʱ���������ڵ�ǰ����������ڻ�ȡbeanʱִ��
     *
     *
     *           bean�ĺ��ô�����-->�����������ڵĳ�ʼ��ǰ����Ӷ���Ĳ�������Ҫʵ��BeanPostProcessor�ӿڣ�
     *          �����õ�IOC�����У���Ҫע����ǣ�bean���ô��������ǵ������ĳһ��bean��Ч���������IOC��
     *          ��������bean����ִ��
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
