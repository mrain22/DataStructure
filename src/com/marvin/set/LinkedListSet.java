package com.marvin.set;

import com.marvin.linkedlist.LinkedList;

/**
 * @Author: Marvin
 * @Date: 2018/12/3 10:30
 * @Version 1.0
 * @Describe: 基于链表的Set实现
 */
public class LinkedListSet<E> implements ISet<E> {

    private LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        //不能添加重复元素，只有在没有情况才添加。
        if (!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
