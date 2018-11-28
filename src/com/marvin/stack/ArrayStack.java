package com.marvin.stack;

import com.marvin.array.Array;

/**
 * @Author: Marvin
 * @Date: 2018/11/21 9:42
 * @Version 1.0
 * @Describe:  自己设计的栈结构，利用到了上一节的动态数组。
 */
public class ArrayStack<T> implements IStack<T> {
    private Array<T> stack;

    /**
     * 构造函数
     */
    public ArrayStack() {
        stack = new Array<>();
    }
    public ArrayStack(int capacity) {
        stack = new Array<>(capacity);
    }

    /**
     * 入栈
     * @param t
     */
    @Override
    public void push(T t) {
        stack.addLast(t);
    }

    /**
     * 出栈
     * @return
     */
    @Override
    public T pop() {
        return stack.removeLast();
    }

    /**
     * 查看栈顶元素
     * @return
     */
    @Override
    public T peek() {
        return stack.getLast();
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append("[");
        for (int i = 0; i <stack.getSize() ; i++) {
            res.append(stack.get(i));
            if (i != stack.getSize()-1){
                res.append(",");
            }
        }
        res.append("] Top");
        return res.toString();
    }

}
