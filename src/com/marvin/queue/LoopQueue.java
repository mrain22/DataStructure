package com.marvin.queue;

/**
 * @Author: Marvin
 * @Date: 2018/11/22 8:35
 * @Version 1.0
 * @Describe:  循环队列
 */
public class LoopQueue<E> implements IQueue<E> {
    private E[] data;
    private int head,tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        head = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if ((tail+1) % data.length == head){
            //说明数组已经满了，需要扩容。
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1) % data.length;
        size++;

    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new RuntimeException("队列中没有元素！");
        }
        E res = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        if (size == getCapacity()/3 && getCapacity()/2 != 0){
            //当数据缩减到当前容量的1/3时，进行缩容。
            resize(getCapacity()/2);
        }
        return res;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new RuntimeException("队列中没有元素！");
        }
        return data[head];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 数组的扩容
     * 将原数组的数据放到新数组中，由于属循环队列，队首和队尾可能不在第一个和最后一个位置。
     * 在新数组中改变队首和队尾的值
     * @param newCapacity
     */
    private void resize(int newCapacity){
         E[] newData  = (E[]) new Object[newCapacity +1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(head+i)%data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }

    /**
     * 注意：在循环遍历时不一样
     * @return
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue:");
        res.append("Head [");
        for (int i = head; i != tail; i = (i+1) % data.length) {
            res.append(data[i]);
            if ((i+1)%data.length != tail){
                res.append(",");
            }
        }
        res.append("] Tail");
        return res.toString();
    }
}
