package com.izumi.mybatis.mapper;

import com.izumi.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    // ����Ա��id��ѯԱ����Ϣ
    Emp getEmpById(@Param("empId") Integer empId);
}
