package com.izumi.mybatis.mapper;

import com.izumi.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {

    // ����id��ѯԱ����Ϣ
    Emp getEmpByEmpId(@Param("empId") Integer empId);
}
