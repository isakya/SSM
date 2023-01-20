package com.izumi.spring.test;

import com.izumi.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    @Test
    public void  test() {
        // ��ȡIOC����
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        // ��ȡIOC�����е�bean
        HelloWorld helloworld = (HelloWorld) ioc.getBean("helloworld");
        helloworld.sayHello();
    }
}
