package com.izumi.controller;

import org.springframework.stereotype.Controller;
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
 */
@Controller
// @RequestMapping("/test")
public class TestRequestMappingController {
    @RequestMapping(
            value = {"/hello", "/abc"},
            method = {RequestMethod.POST, RequestMethod.GET}
    )
    public String hello() {
        return "success";
    }
}
