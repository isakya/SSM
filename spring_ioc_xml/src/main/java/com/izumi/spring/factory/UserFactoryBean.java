package com.izumi.spring.factory;

import com.izumi.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 *
 *  FactoryBean��һ���ӿڣ���Ҫ����һ����ʵ�ָýӿ�
 *      ����������������
 *          getObject(): ͨ��һ�����󽻸�IOC����
 *          getObjectType(): �������ṩ���������
 *          isSingleton(): ���ṩ�Ķ����Ƿ��ǵ���
 *          ����FactoryBean��ʵ��������Ϊbeanʱ���Ὣ��ǰ����getObject()�����صĶ��󽻸�IOC��������
 *
 */



public class UserFactoryBean implements FactoryBean {
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public Object getObject() throws Exception {
        return new User();
    }
}
