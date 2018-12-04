package com.marvin.map;

/**
 * @Author: Marvin
 * @Date: 2018/12/4 9:38
 * @Version 1.0
 * @Describe: 自定义映射接口类
 */
public interface IMap<K,V> {

    void add(K key,V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int gitSize();
    boolean isEmpty();

}
