package com.izumi.mybatis.mapper;

import com.izumi.mybatis.pojo.Emp;

import java.util.List;

public interface DynamicSQLMapper {
    // ����������ѯԱ����Ϣ
    List<Emp> getEmpByCondition(Emp emp);
}
