package com.izumi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *      ResponseEntity: ������Ϊ�����������ķ���ֵ����ʾ��Ӧ�����������������Ӧ����
 */

@Controller
public class FileUpAndDownController {
    @RequestMapping("/test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws
            IOException {
//��ȡServletContext����
        ServletContext servletContext = session.getServletContext();
//��ȡ���������ļ�����ʵ·��
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
//����������
        InputStream is = new FileInputStream(realPath);
//�����ֽ�����
        byte[] bytes = new byte[is.available()];
//���������ֽ�������
        is.read(bytes);
//����HttpHeaders����������Ӧͷ��Ϣ
        MultiValueMap<String, String> headers = new HttpHeaders();
//����Ҫ���ط�ʽ�Լ������ļ�������
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
//������Ӧ״̬��
        HttpStatus statusCode = HttpStatus.OK;
//����ResponseEntity����
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
                statusCode);
//�ر�������
        is.close();
        return responseEntity;
    }
}
