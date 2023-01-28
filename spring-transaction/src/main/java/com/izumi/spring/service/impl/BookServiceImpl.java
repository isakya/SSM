package com.izumi.spring.service.impl;

import com.izumi.spring.dao.BookDao;
import com.izumi.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
/*    @Transactional(
            // readOnly = true
            // timeout = 3 // 3��
            // noRollbackFor = ArithmeticException.class
            // noRollbackForClassName = "java.lang.ArithmeticException"
            // isolation = Isolation.DEFAULT
            propagation = Propagation.REQUIRES_NEW
    )*/
    public void buyBook(Integer userId, Integer bookId) {
        // ��ѯͼ��ļ۸�
        Integer price = bookDao.getPriceByBookId(bookId);

        // ����ͼ��Ŀ��
        bookDao.updateStock(bookId);

        // �����û������
        bookDao.updateBalance(userId, price);
    }
}
