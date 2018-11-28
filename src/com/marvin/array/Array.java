package com.marvin.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Marvin
 * @Date: 2018/11/19 20:32
 * @Version 1.0
 * @Describe: 封装自己的数组实现增删改查
 */
public class Array<T> {
    private T[] data;
    /** 指针所在的位置*/
    private int pointer;

    /**
     * 传入容量的构造方法
     * @param capacity 容量
     */
    public  Array(int capacity){
        //data = new T[capacity];  这种写法是不支持的
        data = (T[])new Object[capacity];
        this.pointer = 0;
    }

    /**
     * 默认开辟10个空间。
     */
    public Array(){
        this(10);
    }


    /**
     * 获取当前数组有多少元素
     * @return
     */
    public int getSize(){
        return pointer;
    }

    /**
     * 获取当前数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断当前数组内数据是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.pointer ==0;
    }

    /**
     * 向数据末尾添加一个元素
     * @param element
     */
    public void addLast(T element){
//        if (this.pointer == data.length){
//            throw new RuntimeException("数组已满，不能再添加元素！");
//        }
//        data[this.pointer] = element;
//        this.pointer++;
        add(pointer,element);
    }

    /**
     * 在数组开头添加一个元素
     * @param element
     */
    public void addFirst(T element){
        add(0,element);
    }
    /**
     * 在index位置插入元素element
     * @param index
     * @param element
     */
    public void add(int index,T element){
        if (index < 0 || index > pointer){
            throw new RuntimeException("添加失败，传入的索引非法！");
        }
        if (pointer == data.length){
//            throw new RuntimeException("数组已满，不能再添加元素！");
//            数组满了时，动态扩容。
            resize(data.length*2);
        }
        for (int i = pointer -1;i >= index;i--){
            data[i+1] = data[i];
        }
        data[index] = element;
        pointer++;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",pointer,data.length));
        res.append("[");
        for (int i = 0; i < pointer; i++) {
            res.append(data[i]);
            if (i != pointer-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    /**
     * 根据索引获取相应元素
     * @param index
     * @return
     */
    public T get(int index){
        if (index < 0 || index >= pointer){
            throw new RuntimeException("错误索引，找不到该索引！");
        }
        return data[index];
    }
    public T getFirst(){
        return get(0);
    }
    public T getLast(){
        return get(pointer-1);
    }

    /**
     * 修改指定索引位置的元素
     * @param index
     * @param element
     */
    public void set(int index , T element){
        if (index < 0 || index >= pointer){
            throw new RuntimeException("错误索引，找不到该索引！");
        }
        data[index] = element;
    }

    /**
     * 查看该数组中是否包含element这个元素
     * @param element
     * @return
     */
    public boolean contains(T element){
        for (int i = 0; i < pointer ; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查询该元素对应的索引是多少，如果不存在该元素返回-1
     * @param element
     * @return
     */
    public int findIndex(T element){
        for (int i = 0; i < pointer ; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据索引删除指定元素
     * @param index
     * @return
     */
    public T remove(int index){
        if (index < 0 || index >= pointer){
            throw new RuntimeException("错误索引，找不到该索引！");
        }
        T res = data[index];
        for (int i = index+1; i < pointer ; i++) {
            data[i-1] = data[i];
        }
        pointer--;
        data[pointer] = null;
        if ((pointer < (data.length)/3) && ((data.length)/2 !=0 )){
            resize(data.length/2);
        }
        return res;
    }

    /**
     * 从数组开头删除一个元素
     * @return
     */
    public T removeFirst(){
        return  remove(0);
    }

    /**
     * 从数组数据的最后一位删除元素
     * @return
     */
    public T removeLast(){
        return remove(pointer-1);
    }

    /**
     * 根据元素删除
     * @param element
     */
    public void removeByElement(T element){
        int index = findIndex(element);
        Map map = new HashMap();
        remove(index);
    }

    /**
     * 重新给数组分配空间
     * @param newCapacity
     */
    private void resize(int newCapacity){
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < pointer; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
