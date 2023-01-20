package com.izumi.mybatis.mapper;

import com.izumi.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    // 通过分步查询 查询员工以及所对应的部门信息的第二步
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);
}
