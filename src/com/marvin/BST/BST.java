package com.marvin.BST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Marvin
 * @Date: 2018/11/23 15:20
 * @Version 1.0
 * @Describe: 二分搜索树
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二叉搜索树中添加新的元素e
     * @param e
     */
    public void add(E e) {
        //调用私有的递归算法
        root = add(root, e);
    }
    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法。
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {
        if (node == null){
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     *  看二分搜索树是否包含元素e
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    /**
     *看以node为根的二分搜索树是否包含元素额，递归算法
     */
    private boolean contains(Node node,E e){
        if (node ==null){
            return false;
        }
        if (e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else {
            //e.compareTo(node.e) > 0
            return contains(node.right,e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     *前序遍历以node为根的二分搜索树，递归算法
     */
    private void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            //对节点的处理（从队列中取出，然后输出）
            Node cur = q.remove();
            System.out.println(cur.e);

            //将该节点的左右节点入队
            if (cur.left != null){
                ((LinkedList<Node>) q).add(cur.left);
            }
            if (cur.right != null){
                ((LinkedList<Node>) q).add(cur.right);
            }
        }
    }

    //寻找二分搜索树的最小元素
    public E minimum(){
        if (size == 0){
            throw new RuntimeException("BST is empty!");
        }

        return minimum(root).e;
    }
    private Node minimum(Node node){
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    //寻找二分搜索树的最大元素
    public E maxmum(){
        if (size == 0){
            throw new RuntimeException("BST is empty!");
        }
        return maxmum(root).e;
    }
    private Node maxmum(Node node){
        if (node.right == null){
            return node;
        }
        return maxmum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在的节点，返回最小值
     */
    public E removeMin(){
        E res = minimum();
        root = removeMin(root);
        return res;
    }

    /**
     * 删除以node为根的二分搜索树中最小值的节点
     * 返回删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node){
        //递归到底的情况
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return  rightNode;
        }
        
        node.left = removeMin(node.left);
        return node;
    }
    /**
     * 从二分搜索树中删除最大值所在的节点，返回最大值
     */
    public E removeMax(){
        E res = maxmum();
        root = removeMax(root);
        return res;
    }

    /**
     * 删除以node为根的二分搜索树中最大值的节点
     * 返回删除节点后新的二分搜索树的根
     */
    private Node removeMax(Node node){
        //递归到底的情况
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return  leftNode;
        }

        node.right = removeMin(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除指定元素为e的节点
     */
    public void remove(E e){
        root = remove(root,e);
    }

    /**
     *删除以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     */
    private Node remove(Node node,E e){
        //树到底的情况，说明该树中没有e这个元素
        if (node == null){
            return null;
        }

        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }else {
            //e.compareTo(node.e) == 0

            if (node.left == null){
//                Node rightNode = node.right;
//                node.right = null;
//                size--;
//                return rightNode;
                return removeMin(node);
            }
            if (node.right == null){
//                Node leftNode  = node.left;
//                node.left = null;
//                size--;
//                return leftNode;
                return removeMax(node);
            }
            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点代替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
    //生成以node为根节点，深度为depth的描述二分搜索树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }
    //生成深度字符串
    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
