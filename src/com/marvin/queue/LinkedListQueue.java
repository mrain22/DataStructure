package com.marvin.queue;

import com.marvin.linkedlist.LinkedList;

/**
 * @Author: Marvin
 * @Date: 2018/11/23 8:36
 * @Version 1.0
 * @Describe: 带尾指针的链表实现队列
 */
public class LinkedListQueue<E> implements IQueue<E> {

    /**
     * 内部节点类
     */
    private class Node{
        public E e;
        public Node next;

        public Node (E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;
    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 入队，要从链表的尾部进行。
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if (tail == null){
            //此时队列中没有元素
            tail = new Node(e);
            head = tail;
        }else {
            //队列中已经有元素了
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 出队，从链表头出队
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        Node resNode = head;
        head = head.next;
        if (head == null){
            //head为空说明队列中已经没有元素了，维护下tail的指向。
            tail = null;
        }
        resNode.next = null;
        size--;
        return resNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        return head.e;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public  String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue:head");
        Node cur = head;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NUll  tail");
        return res.toString();
    }


}
