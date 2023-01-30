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
 *      查询所有的员工信息 --> /employee --> get
 *      跳转到添加页面 --> /to/add --> get
 *      新增员工信息 --> /employee --> post
 *      跳转到修改页面 --> /employee/1 --> get
 *      修改员工信息 --> /employee --> put
 *      删除员工信息 --> /employee/1 --> delete
 *
 */

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {
        // 获取所有的员工信息
        Collection<Employee> allEmployee = employeeDao.getAll();
        // 将所有的员工信息在请求域中共享
        model.addAttribute("allEmployee", allEmployee);
        // 跳转到列表页面
        return "employee_list";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        // 保存员工信息
        employeeDao.save(employee);
        // 重定向到列表功能： /employee
        return "redirect:/employee";
    }


}
