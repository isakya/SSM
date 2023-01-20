package com.izumi.mybatis.mapper;

import com.izumi.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    // ͨ���ֲ���ѯ ��ѯԱ���Լ�����Ӧ�Ĳ�����Ϣ�ĵڶ���
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    // ��ѯ�����Լ������е�Ա����Ϣ
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    // ͨ���ֲ���ѯ�����Լ������е�Ա����Ϣ�ĵ�һ��
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
