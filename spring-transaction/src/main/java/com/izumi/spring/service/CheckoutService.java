package com.izumi.spring.service;

public interface CheckoutService {

    void checkout(Integer userId, Integer[] bookIds);
}
