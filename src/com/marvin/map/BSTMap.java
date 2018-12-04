package com.marvin.map;

/**
 * @Author: Marvin
 * @Date: 2018/12/4 14:19
 * @Version 1.0
 * @Describe: 基于二分搜索树的Map的实现
 */
public class BSTMap<K extends Comparable<K>,V> implements IMap<K,V> {

    private class Node{
        public K key;
        public V val;
        public Node left,right;

        public Node(K key,V val){
            this.key = key;
            this.val = val;
            left = null;
            right = null;
        }
    }

    private Node root;
    private  int size;


    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }
    /**
     * 向以node为根的二分搜索树中插入元素（key,value），递归算法
     * 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node,K key,V val){
        if (node == null){
            size++;
            return new Node(key,val);
        }
        if (key.compareTo(node.key) < 0){
            node.left = add(node.left,key,val);
        }else if (key.compareTo(node.key) > 0){
            node.right = add(node.right,key,val);
        }else{//key.compareTo(node.key) == 0  相等时认为是改变元素的值
            node.val = val;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if (node !=null){
            root = remove(root,key);
            return node.val;
        }
        return null;
    }

    private Node remove(Node node,K key){
        if (node == null){
            return null;
        }
        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            return node;
        }else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            return node;
        }else {//key.compareTo(node.key) == 0
            //待删除节点左子树为空
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点的右子树为空
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //待删除节点的左右子树均不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点代替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;

            return successor;
        }
    }

    /**
     * 返回以node为根最小值所在的节点
     */
    private Node minimum(Node node){
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }
    /**
     *     删除以node为根的最小的节点
     */
    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 辅助函数
     * 返回以node为节点的二分搜索树中，key所在的节点
     */
    private Node getNode(Node node,K key){
        if(node == null){
            return null;
        }
        if (key.compareTo(node.key) == 0){
            return node;
        }else if (key.compareTo(node.key) < 0){
            return getNode(node.left,key);
        }else {//(key.compareTo(node.key) > 0)
            return getNode(node.right,key);
        }
    }
    @Override
    public boolean contains(K key) {
        return getNode(root,key) !=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        return node == null ? null : node.val;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root,key);
        if (node == null){
            throw new RuntimeException("不存在该元素！");
        }
        node.val = newValue;
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
