package com.izumi.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // 将当前类标识位异常处理的组件
public class ExceptionController {
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable ex, Model model) {
        // ex表示控制器方法所出现的异常
        model.addAttribute("ex", ex);
        return "error";
    }
}
