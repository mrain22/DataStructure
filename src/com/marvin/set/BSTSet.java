package com.marvin.set;

import com.marvin.BST.BST;

/**
 * @Author: Marvin
 * @Date: 2018/11/28 10:17
 * @Version 1.0
 * @Describe: 基于二分搜索树的集合Set
 */
public class BSTSet<E extends Comparable<E>> implements ISet<E> {
    private BST<E> bst;

    public BSTSet(){
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
