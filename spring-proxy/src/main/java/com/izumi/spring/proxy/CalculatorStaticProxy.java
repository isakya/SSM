package com.izumi.spring.proxy;

public class CalculatorStaticProxy implements Calculator {

    private CalculatorImpl target;

    public CalculatorStaticProxy(CalculatorImpl target) {
        this.target = target;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("��־��������add��������" + i + "," + j);
        int result = target.add(i, j);
        System.out.println("��־��������add�������" + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("��־��������sub��������" + i + "," + j);
        int result = target.sub(i, j);
        System.out.println("��־��������sub�������" + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("��־��������mul��������" + i + "," + j);
        int result = target.mul(i, j);
        System.out.println("��־��������mul�������" + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("��־��������div��������" + i + "," + j);
        int result = target.div(i, j);
        System.out.println("��־��������div�������" + result);
        return result;
    }
}
