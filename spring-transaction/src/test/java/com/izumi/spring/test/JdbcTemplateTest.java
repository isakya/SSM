package com.izumi.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// ָ����ǰ��������Spring�Ĳ��Ի�����ִ�У���ʱ�Ϳ���ͨ��ע��ķ�ʽֱ�ӻ�ȡIOC�����е�bean
@RunWith(SpringJUnit4ClassRunner.class)
// ����Spring���Ի����������ļ�
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInstance() {
        String sql = "insert into t_user values(null, ?,?,?,?,?)";
        jdbcTemplate.update(sql, "root", "123", 23, "Ů", "123@qq.com");
    }
}
