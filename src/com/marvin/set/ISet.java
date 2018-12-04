package com.marvin.set;

/**
 * @Author: Marvin
 * @Date: 2018/11/28 9:34
 * @Version 1.0
 * @Describe: 集合接口
 */
public interface ISet<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
