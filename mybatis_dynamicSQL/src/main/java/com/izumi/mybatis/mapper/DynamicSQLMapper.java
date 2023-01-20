package com.izumi.mybatis.mapper;

import com.izumi.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    // ����������ѯԱ����Ϣ
    List<Emp> getEmpByCondition(Emp emp);

    // ʹ��choose��ѯԱ����Ϣ
    List<Emp> getEmpByChoose(Emp emp);

    // �������Ա����Ϣ
    void insertMoreEmp(@Param("emps") List<Emp> emps);

    // ����ɾ��Ա����Ϣ
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);


}
