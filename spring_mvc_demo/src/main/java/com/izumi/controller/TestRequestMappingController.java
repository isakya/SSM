package com.izumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 1��@RequestMappingע���ʶ��λ��
 * @RequestMapping��ʶһ���ࣺ����ӳ�����������·���ĳ�ʼ��Ϣ
 * @RequestMapping��ʶһ������������ӳ������·���ľ�����Ϣ
 * 2��@RequestMappingע��value����
 * ���ã�ͨ�����������·��ƥ������
 * value�������������ͣ�����ǰ��������������������·��ƥ��value�����е��κ�һ��ֵ
 * ��ǰ����ͻᱻע������ʶ�ķ������д���
 */
@Controller
// @RequestMapping("/test")
public class TestRequestMappingController {
    @RequestMapping({"/hello", "/abc"})
    public String hello() {
        return "success";
    }
}
