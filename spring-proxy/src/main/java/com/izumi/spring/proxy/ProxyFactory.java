package com.izumi.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target;
    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        /***
         *      ClassLoader Loader: ָ�����ض�̬���ɵĴ�������������
         *      Class[] interfaces: ��ȡĿ�����ʵ�ֵ����нӿڵ�class���������
         *      InvocationHandler h: ���ô������еĳ��󷽷������д
         *
         *
         */

        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();

        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("��־��������"+ method.getName() + "��������" + Arrays.toString(args));
                // proxy��ʾ������� method��ʾҪִ�еķ����� args��ʾҪִ�еķ����Ĳ����б�
                Object result = method.invoke(target, args);
                System.out.println("��־��������"+ method.getName() + "�������" + result);
                return result;
            }
        };

        return Proxy.newProxyInstance(classLoader, interfaces, h);
    }
}
