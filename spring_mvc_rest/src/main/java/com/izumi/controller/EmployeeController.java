package com.izumi.controller;

import com.izumi.dao.EmployeeDao;
import com.izumi.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 *      ��ѯ���е�Ա����Ϣ --> /employee --> get
 *      ��ת������ҳ�� --> /to/add --> get
 *      ����Ա����Ϣ --> /employee --> post
 *      ��ת���޸�ҳ�� --> /employee/1 --> get
 *      �޸�Ա����Ϣ --> /employee --> put
 *      ɾ��Ա����Ϣ --> /employee/1 --> delete
 *
 */

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {
        // ��ȡ���е�Ա����Ϣ
        Collection<Employee> allEmployee = employeeDao.getAll();
        // �����е�Ա����Ϣ���������й���
        model.addAttribute("allEmployee", allEmployee);
        // ��ת���б�ҳ��
        return "employee_list";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        // ����Ա����Ϣ
        employeeDao.save(employee);
        // �ض����б����ܣ� /employee
        return "redirect:/employee";
    }


}