package com.izumi.spring.test;

import com.izumi.spring.pojo.Person;
import com.izumi.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXmlTest {
    /***
     * ��ȡbean�����ַ�ʽ��
     * 1������bean��id��ȡ
     * 2������bean�����ͻ�ȡ�����ã�
     * ע�⣺�������ͻ�ȡbeanʱ��Ҫ��IOC����������ֻ��һ������ƥ���bean
     * ��û���κ�һ������ƥ���bean����ʱ�׳��쳣�� NoSuchBeanDefinitionException
     * ���ж������ƥ���bean����ʱ�׳��쳣�� NoUniqueBeanDefinitionException
     * 3������bean��id�����ͻ�ȡ
     *
     * ���ۣ�
     *  ������������ȡbeanʱ��������beanΨһ�Ե�ǰ���£�
     *  ��ʵ֪ʶ����[����instanceofָ��������]�ķ��ؽ��
     *  ֻҪ���ص���true�Ϳ����϶�Ϊ������ƥ�䣬���ܹ���ȡ����
     *  ����ͨ��bean�����ͣ�bean���̳е����͵����ͣ�bean��ʵ�ֵĽӿڵ����Ͷ����Ի�ȡbean
     */

    @Test
    public void test() {
        // ��ȡIOC����
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        // ��ȡbean
        // Student studentOne = (Student) ioc.getBean("studentOne");
        // Student student = ioc.getBean(Student.class);
        // Student student = ioc.getBean("studentOne", Student.class);

        Person person = ioc.getBean(Person.class);
        System.out.println(person);
    }

    @Test
    public void testDI() {
        // ��ȡIOC����
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        // ��ȡbean
        Student student = ioc.getBean("studentTwo", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDI1() {
        // ��ȡIOC����
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        // ��ȡbean
        Student student = ioc.getBean("studentThree", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDI2() {
        // ��ȡIOC����
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        // ��ȡbean
        Student student = ioc.getBean("studentFive", Student.class);
        System.out.println(student);
    }
}
