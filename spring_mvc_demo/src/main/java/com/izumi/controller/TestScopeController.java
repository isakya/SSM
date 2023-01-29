package com.izumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *      ������������ݣ�
 *          1��ͨ��ModelAndView��������������
 *              ʹ��ModelAndViewʱ������ʹ����Model������������������
 *              ʹ��View���������߼���ͼ�����ǿ���������һ��Ҫ��ModelAndView��Ϊ�����ķ���ֵ
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
}
