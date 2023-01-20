package com.izumi.mybatis.mapper;

import com.izumi.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {

    // ����id��ѯԱ����Ϣ
    Emp getEmpByEmpId(@Param("empId") Integer empId);

    // ��ȡԱ���Լ���Ӧ�Ĳ�����Ϣ
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    // ͨ���ֲ���ѯ ��ѯԱ���Լ�����Ӧ�Ĳ�����Ϣ�ĵ�һ��
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);
}
