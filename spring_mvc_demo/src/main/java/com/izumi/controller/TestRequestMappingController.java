package com.izumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/***
 * 1��@RequestMappingע���ʶ��λ��
 * @RequestMapping��ʶһ���ࣺ����ӳ�����������·���ĳ�ʼ��Ϣ
 * @RequestMapping��ʶһ������������ӳ������·���ľ�����Ϣ
 * 2��@RequestMappingע��value����
 * ���ã�ͨ�����������·��ƥ������
 * value�������������ͣ�����ǰ��������������������·��ƥ��value�����е��κ�һ��ֵ
 * ��ǰ����ͻᱻע������ʶ�ķ������д���
 *
 * 3��@RequestMappingע���method����
 * ���ã�ͨ�����������ʽƥ������
 *      method������RequestMethod���͵����飬����ǰ����������͵�����ʽƥ��method�����е��κ�һ������ʽ��
 *      ��ǰ����ͻᱻע������ʶ�ķ������д���
 *
 * ��@RequestMapping�Ļ����ϣ��������ʽ��һЩ����ע�⣺
 *      @GetMapping, @PostMapping, @DeleteMapping, @PutMapping
 *
 * 4��@RequestMappingע���params����
 *      ���ã�ͨ��������������ƥ�����󣬼���������͵��������������������params���Ե�����
 *          params����ʹ�����ֱ��ʽ��
 *              "param": ��ʾ��ǰ�������������б���Я��param����
 *              "!param": ��ʾ��ǰ��������������һ������Я��param����
 *              "param=value": ��ʾ��ǰ�������������б���Я��param��������ֵ����Ϊvalue
 *              "param!=value": ��ʾ��ǰ�������������п��Բ�Я��param��������Я��ʱֵ����Ϊvalue
 *
 * 5��@RequestMappingע���headers����
 *      ���ã�ͨ�����������ͷ��Ϣƥ�����󣬼���������͵���������ͷ��Ϣ��������headers���Ե�����
 *
 * 6��SpringMVC֧��ant����·��
 *      ��@RequestMappingע���value����ֵ������һЩ�����ַ�
 *          ?: ����ĵ����ַ�(�������� ? ��)
 *          *: 0�� �� ��� �����ַ�(��������?��/)
 *          **: �������������Ŀ¼��ע��ʹ�÷�ʽ�� **ֻ��д��˫б���У�ǰ�������κ������ַ�
 *
 *
 * 7��@RequestMappingע��ʹ��·���е�ռλ��
 *      ��ͳ�� /deleteUser?id=1
 *      rest��/user/delete/1
 *          ��Ҫ��@RequestMappingע���value���������õ�·���У�ʹ��{xxx}�ķ�ʽ��ʾ·���е����ݣ�
 *          ��ͨ��@PathVariable("xxx")ע�⣬��ռλ������ʶ��ֵ�Ϳ������������βν��а�
 */
@Controller
// @RequestMapping("/test")
public class TestRequestMappingController {
    @RequestMapping(
            value = {"/hello", "/abc"},
            method = {RequestMethod.POST, RequestMethod.GET},
            // params = {"username", "!password", "age=20", "gender!=��"}
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
