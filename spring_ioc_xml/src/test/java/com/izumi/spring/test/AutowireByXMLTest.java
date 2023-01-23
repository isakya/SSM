package com.izumi.spring.test;

import com.izumi.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireByXMLTest {
    /**
     * �Զ�װ�䣺
     *      ����ָ���Ĳ��ԣ���IOC��������Ʊĳ��bean���Զ�Ϊbean�е������͵����Ի�ӿ����͵����Ը�ֵ
     *      ����ͨ��bean��ǩ�е�autowire���������Զ�װ��Ĳ���
     *      �Զ�װ��Ĳ��ԣ�
     *          1��no, default: ��ʾ��װ�䣬��bean�е����Բ��Զ�ƥ��ĳ��beanΪ���Ը�ֵ
     *          2��byType: ����Ҫ��ֵ�����Ե����ͣ���IOC������ƥ��ĳ��bean��Ϊ���Ը�ֵ
     *          3��byName: ��Ҫ��ֵ�����Ե���������Ϊbean��id��IOC������ƥ��ĳ��bean��Ϊ���Ը�ֵ
     *
     *      ע�⣺
     *          a>��ͨ������û���ҵ��κ�һ������ƥ���bean����ʱ��װ�䣬����ʹ��Ĭ��ֵ
     *          b>��ͨ�������ҵ��˶������ƥ���bean����ʱ���׳��쳣��NoUniqueBeanDefinitionException
     *          �ܽ᣺
     *             1����ʹ��byTypeʵ���Զ�װ��ʱ��IOC����������ֻ��һ������ƥ���bean�ܹ�Ϊ���Ը�ֵ
     *             2��������ƥ���bean�ж��ʱ����ʱ����ʹ��byNameʵ���Զ�װ��
     *
     */
    @Test
    public void testAutowire() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");

        UserController userController = ioc.getBean(UserController.class);

        userController.saveUser();
    }
}
