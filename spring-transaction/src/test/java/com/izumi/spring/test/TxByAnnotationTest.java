package com.izumi.spring.test;

import com.izumi.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/***
 * ����ʽ��������ò��裺
 * 1����spring�������ļ����������������
 * 2�����������ע������
 * ����Ҫ���������ķ����ϣ����@Transactionalע�⣬�÷����ͻᱻ�������
 * @Transactionalע���ʶ��λ�ã�
 * 1����ʶ�ڷ�����
 * 2����ʶ�����ϣ����������еķ������ᱻ�������
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxByAnnotationTest {
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook() {
        bookController.buyBook(1, 2);
    }
}
