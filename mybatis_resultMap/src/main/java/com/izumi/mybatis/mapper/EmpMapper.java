package com.izumi.mybatis.mapper;

import com.izumi.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {

    // 根据id查询员工信息
    Emp getEmpByEmpId(@Param("empId") Integer empId);

    // 获取员工以及对应的部门信息
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);
}
