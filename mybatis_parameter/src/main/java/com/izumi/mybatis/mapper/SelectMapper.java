package com.izumi.mybatis.mapper;

import com.izumi.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * ע�⣺
 * 1. ��sql����ѯ�Ľ��Ϊ ����ʱ��һ��������ʵ����������Ϊ�����ķ���ֵ
 * ������׳��쳣
 *
 * 2. ��sql����ѯ�Ľ��Ϊ һ��ʱ����ʱ����ʹ��ʵ�������ͻ�list����������Ϊ�����ķ���ֵ
 */

public interface SelectMapper {
    // ����id��ѯ�û���Ϣ
    User getUserById(@Param("id") Integer id);

    // ��ѯ���е��û���Ϣ
    List<User> getAllUser();

    // ��ѯ�û���������
    Integer getCount();

    // ����id��ѯ�û���ϢΪmap����
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    // ��ѯ���е��û���ϢΪmap����
    List<Map<String, Object>> getAllUserToMap(); // �������һ

    // @MapKey("id") // �Ѳ�ѯ����ٷ���һ��map���ϵ��У���ע���id��Ϊ������ѯ�����Ϊֵ
    // Map<String, Object> getAllUserToMap(); // ���������
    /***
     * ��ѯ���е��û���ϢΪmap����
     * ����ѯ�������ж���ʱ������Ҫ��ÿ������ת��Ϊmap����
     * ��ʱ����������£�
     *
     *  1����mapper�ӿڷ����ķ���ֵ����Ϊ����map��list����
     *
     *      �磺List<Map<String, Object>> getAllUserToMap(); // �������һ
     *      ��ѯ�����[{password=123456, gender=��, id=4, age=23, email=12345@qq.com, username=admin}, {password=123456, gender=1, id=10, age=33, email=123@qq.com, username=root}, {password=123456, gender=1, id=11, age=33, email=123@qq.com, username=root}]
     *
     *  2�����Խ�ÿ������ת����map���Ϸ���һ�����map�У����Ǳ���Ҫͨ��@MapKeyע�⣬
     *     ����ѯ��ĳ���ֶε�ֵ��Ϊ���map����
     *
     *     �磺
     *          @MapKey("id") // �Ѳ�ѯ����ٷ���һ��map���ϵ��У���ע���id��Ϊ������ѯ�����Ϊֵ
     *          Map<String, Object> getAllUserToMap(); // ���������
     *
     *     ��ѯ�����{4={password=123456, gender=��, id=4, age=23, email=12345@qq.com, username=admin}, 10={password=123456, gender=1, id=10, age=33, email=123@qq.com, username=root}, 11={password=123456, gender=1, id=11, age=33, email=123@qq.com, username=root}}
     */
}
