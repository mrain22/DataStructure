package com.marvin.linkedlist;

import javax.swing.text.rtf.RTFEditorKit;

/**
 * @Author: Marvin
 * @Date: 2018/11/22 14:29
 * @Version 1.0
 * @Describe: 链表
 */
public class LinkedList<E> {
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

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * 获取链表中元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表中间添加元素
     * 关键：找到要添加节点位置的前一个节点
     * @param index
     * @param e
     */
    public void add(int index,E e){
        if (index < 0 || index > size){
            throw new RuntimeException("索引越界！");
        }
        Node prev = dummyHead;
        //找到要插入节点位置的前一个节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e,prev.next);
        size++;
    }

    /**
     * 在链表头添加新的元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }


    /**
     * 在链表末尾添加新的元素e
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获得链表的地index个位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index > size){
            throw new RuntimeException("索引越界！");
        }
        //注意此处的遍历开始的位置是虚拟头结点的下一个。
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    /**
     * 修改链表的第index个位置色元素e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if (index < 0 || index > size){
            throw new RuntimeException("索引越界！");
        }
        //注意此处的遍历开始的位置是虚拟头结点的下一个。
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否存在元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 根据索引删除元素（节点）
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 || index > size){
            throw new RuntimeException("索引越界！");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            //找到要删除节点的前一个节点
            prev = prev.next;
        }
        //删除操作实质上就是改变指针（next）的指向
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;

        return delNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从链表中删除元素e
     * 要删除该元素，需要找到该元素的前驱
     * @param e
     */
    public void removeElement(E e){
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }
        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }



    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur+"->");
            cur = cur.next;
        }
        res.append("NUll");
        return res.toString();
    }

}
