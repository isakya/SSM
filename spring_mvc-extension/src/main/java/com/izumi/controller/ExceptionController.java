package com.izumi.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // ����ǰ���ʶλ�쳣��������
public class ExceptionController {
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable ex, Model model) {
        // ex��ʾ���������������ֵ��쳣
        model.addAttribute("ex", ex);
        return "error";
    }
}
