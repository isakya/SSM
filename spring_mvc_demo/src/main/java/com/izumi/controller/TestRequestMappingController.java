package com.izumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/***
 * 1、@RequestMapping注解标识的位置
 * @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求路径的具体信息
 * 2、@RequestMapping注解value属性
 * 作用：通过请求的请求路径匹配请求
 * value属性是数组类型，即当前浏览器所发送请求的请求路径匹配value属性中的任何一个值
 * 则当前请求就会被注解所标识的方法进行处理
 *
 * 3、@RequestMapping注解的method属性
 * 作用：通过请求的请求方式匹配请求
 *      method属性是RequestMethod类型的数组，即当前浏览器所发送的请求方式匹配method属性中的任何一种请求方式，
 *      则当前请求就会被注解所标识的方法进行处理
 *
 * 在@RequestMapping的基础上，结合请求方式的一些派生注解：
 *      @GetMapping, @PostMapping, @DeleteMapping, @PutMapping
 *
 * 4、@RequestMapping注解的params属性
 *      作用：通过请求的请求参数匹配请求，即浏览器发送的请求请求参数必须满足params属性的设置
 *          params可以使用四种表达式：
 *              "param": 表示当前请求的请求参数中必须携带param参数
 *              "!param": 表示当前请求的请求参数中一定不能携带param参数
 *              "param=value": 表示当前请求的请求参数中必须携带param参数，且值必须为value
 *              "param!=value": 表示当前请求的请求参数中可以不携带param参数，若携带时值不能为value
 *
 * 5、@RequestMapping注解的headers属性
 *      作用：通过请求的请求头信息匹配请求，即浏览器发送的请求，请求头信息必须满足headers属性的设置
 *
 * 6、SpringMVC支持ant风格的路径
 *      在@RequestMapping注解的value属性值中设置一些特殊字符
 *          ?: 任意的单个字符(但不包括 ? 号)
 *          *: 0个 或 多个 任意字符(但不包括?和/)
 *          **: 任意层数的任意目录，注意使用方式： **只能写在双斜线中，前后不能有任何其他字符
 */
@Controller
// @RequestMapping("/test")
public class TestRequestMappingController {
    @RequestMapping(
            value = {"/hello", "/abc"},
            method = {RequestMethod.POST, RequestMethod.GET},
            // params = {"username", "!password", "age=20", "gender!=男"}
            headers = {"referer"}
    )

    public String hello() {
        return "success";
    }

    // @RequestMapping("/a?a/test/ant")
    @RequestMapping("/**/test/ant")
    public String testAnt() {
        return "success";
    }

    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        System.out.println("id:" + id + " username:" + username);
        return "success";
    }
}
