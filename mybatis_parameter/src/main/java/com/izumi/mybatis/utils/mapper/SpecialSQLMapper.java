package com.izumi.mybatis.utils.mapper;

import com.izumi.mybatis.utils.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {
    // ͨ���û���ģ����ѯ�û���Ϣ
    List<User> getUserByLike(@Param("mohu") String mohu);

    // ����ɾ������
    void deleteMoreUser(@Param("ids") String ids);

    // ��̬���ñ�������ѯ�û���Ϣ
    List<User> getUserList(@Param("tableName") String tableName);

    // ����û���Ϣ����ȡ����������
    void insertUser(User user);
}
