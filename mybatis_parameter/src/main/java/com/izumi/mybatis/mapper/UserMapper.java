package com.izumi.mybatis.mapper;

import com.izumi.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/***
 *      MyBatis��ȡ����ֵ�����ַ�ʽ��#{} �� ${}
 *      1. ��mapper�ӿڷ����Ĳ���Ϊ���������������ͣ�
 *         ��ʱ����ͨ�� #{} �� ${} ����������ݻ�ȡ����ֵ��һ��Ҫע�� ${} �ĵ���������
 *              ע�� ${}���������ַ���ƴ�ӣ�#{}��������ռλ����ֵ
 *
 *      2. ��mapper�ӿڷ����Ĳ���Ϊ��������������ͣ�
 *         ��ʱMyBatis�Ὣ��������map�����У������ַ�ʽ�洢����
 *              a. ��arg0��arg1...Ϊ�����Բ���Ϊֵ
 *              b. ��param1��param2...Ϊ�����Բ���Ϊֵ
 *         ��ˣ�ֻ��Ҫͨ��#{}��${}����map���ϵļ����Ϳ��Ի�ȡ���Ӧ��ֵ
 *
 *      3. ��mapper�ӿڵķ����Ĳ���Ϊmap�������͵Ĳ�����
 *         ֻ��Ҫͨ��#{}��${}����map���ϵļ����Ϳ��Ի�ȡ���Ӧ��ֵ
 *
 *      4. ��mapper�ӿڷ����Ĳ���Ϊʵ�������͵Ĳ���
 *         ֻ��Ҫͨ��#{}��${}����ʵ�����е����������Ϳ��Ի�ȡ���Ӧ������ֵ
 *
 *      5. ������mapper�ӿڷ����Ĳ���������@Paramע��
 *          ��ʱMyBatis�Ὣ��Щ��������map�У������ַ�ʽ���д洢
 *              a. ��@Paramע���value����Ϊ�����Բ���Ϊֵ
 *              b. ��@Param1��@Param2...Ϊ�����Բ���Ϊֵ
 *          ֻ��Ҫͨ��#{} �� #{}����map���ϵļ����Ϳ��Ի�ȡ��Ӧ��ֵ
 */
public interface UserMapper {
    // �����û�����ѯ�û���Ϣ
    User getUserByUsername(String username);

    // ��֤��½
    User checkLogin(String username, String password);

    // ��֤��½����map��������Ϊ������
    User checkLoginByMap(Map<String, Object> map);

    // ����û�
    void insertUser(User user);

    // ��֤��½��@Paramע�⣩
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
