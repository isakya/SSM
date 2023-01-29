package com.izumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 *      ������������ݣ�
 *          1��ͨ��ModelAndView��������������
 *              ʹ��ModelAndViewʱ������ʹ����Model������������������
 *              ʹ��View���������߼���ͼ�����ǿ���������һ��Ҫ��ModelAndView��Ϊ�����ķ���ֵ
 *
 *          2��ʹ��Model��������������
 *          3��ʹ��ModelMap��������������
 *          4��ʹ��map��������������
 *
 *          5��Model��ModelMap��map�Ĺ�ϵ
 *              ��ʵ�ڵײ��У���Щ���͵��β����ն���ͨ��BindingAwareModelMap����
 *
 *
 *
 *
 */

@Controller
public class TestScopeController {
    @RequestMapping("/test/mav")
    public ModelAndView testMAV() {
        /***
         * ModelAndView����Model��view�Ĺ���
         * Model�����������й�������
         * View�������߼���ͼʵ��ҳ����ת
         */
        ModelAndView mav = new ModelAndView();

        // ���������й�������
        mav.addObject("testRequestScope", "hello ModelAndView");
        // �����߼���ͼʵ��ҳ����ת
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "hello Model");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "hello ModelMap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map) {
        map.put("testRequestScope", "hello map");
        return "success";
    }



    @RequestMapping("/test/session")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello, session");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope", "hello application");
        return "success";
    }
}
