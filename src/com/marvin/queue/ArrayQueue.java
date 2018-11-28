package com.marvin.queue;

import com.marvin.array.Array;

/**
 * @Author: Marvin
 * @Date: 2018/11/21 20:14
 * @Version 1.0
 * @Describe:  自定义队列的实现
 */
public class ArrayQueue<E> implements IQueue<E> {

    private Array<E> queue;

    public ArrayQueue(){
        queue = new Array<>();
    }
    public ArrayQueue(int capacity){
        queue = new Array<>(capacity);
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        queue.addLast(e);
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        return queue.removeFirst();
    }

    /**
     * 获取队首
     * @return
     */
    @Override
    public E getFront() {
        return queue.getFirst();
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue:");
        res.append("Head [");
        for (int i = 0; i <queue.getSize() ; i++) {
            res.append(queue.get(i));
            if (i != queue.getSize()-1){
                res.append(",");
            }
        }
        res.append("] Tail");
        return res.toString();
    }
}
