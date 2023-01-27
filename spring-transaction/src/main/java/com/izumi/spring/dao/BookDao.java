package com.izumi.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;

public interface BookDao {
    // 根据图书id查看图书价格
    Integer getPriceByBookId(Integer bookId);

    // 查看图书库存
    void updateStock(Integer bookId);

    // 更新余额
    void updateBalance(Integer userId, Integer price);
}
