package com.izumi.mybatis.test;

import com.izumi.mybatis.mapper.DynamicSQLMapper;
import com.izumi.mybatis.pojo.Emp;
import com.izumi.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DynamicMapperTest {

    @Test
    public void testGetEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "ÕÅÈý", 20, "ÄÐ");
        List<Emp> list = mapper.getEmpByCondition(emp);
        list.forEach(System.out::println);
    }
}
