package com.marvin.queue;

/**
 * @Author: Marvin
 * @Date: 2018/11/21 20:12
 * @Version 1.0
 * @Describe: 自定义的队列接口
 */
public interface IQueue<E> {
    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
