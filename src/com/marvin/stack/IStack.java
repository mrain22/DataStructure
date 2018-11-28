package com.marvin.stack;

/**
 * @Author: Marvin
 * @Date: 2018/11/21 9:38
 * @Version 1.0
 * @Describe: 栈的接口
 */
public interface IStack<T> {

    void push(T t);
    T pop();
    T peek();
    int getSize();
    boolean isEmpty();

}
