package com.marvin.stack;

import com.marvin.linkedlist.LinkedList;

/**
 * @Author: Marvin
 * @Date: 2018/11/22 20:23
 * @Version 1.0
 * @Describe:
 */
public class LinkedListStack<E> implements IStack<E> {
    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
