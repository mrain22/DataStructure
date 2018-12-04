package com.marvin.map;

/**
 * @Author: Marvin
 * @Date: 2018/12/4 10:00
 * @Version 1.0
 * @Describe:
 */
public class LinkedListMap<K,V> implements IMap<K,V> {

    private class Node{
        public K key;
        public V val;
        public Node next;

        public Node(K key,V val,Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }

        public Node(K key){
            this(key,null,null);
        }
        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + val.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 辅助函数
     * @param key
     * @return
     */
    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null){
            //在链表头添加一个元素
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }else {
            //如果不为空，可以看做修改值，或者抛出错误。
            node.val = value;
        }
    }

    /**
     * 相对其他操作，此操作是最复杂的的操作，找到要删除的上一个节点。
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.key.equals(key)){
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null){
            Node delNode =  prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.val;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node  = getNode(key);
        return node == null? null:node.val;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node == null){
            throw new RuntimeException("键值不存在！");
        }else{
            node.val = newValue;
        }
    }

    @Override
    public int gitSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
