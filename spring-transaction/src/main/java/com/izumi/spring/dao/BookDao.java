package com.izumi.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;

public interface BookDao {
    // ����ͼ��id�鿴ͼ��۸�
    Integer getPriceByBookId(Integer bookId);

    // �鿴ͼ����
    void updateStock(Integer bookId);

    // �������
    void updateBalance(Integer userId, Integer price);
}
