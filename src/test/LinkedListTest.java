package test;

import com.marvin.linkedlist.LinkedList;
import com.marvin.queue.LinkedListQueue;

/**
 * @Author: Marvin
 * @Date: 2018/11/22 19:48
 * @Version 1.0
 * @Describe:
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedListQueue<Integer> llq = new LinkedListQueue<>();
        for (int i = 0; i < 8; i++) {
            llq.enqueue(i);
        }
        System.out.println(llq);

        llq.dequeue();
        System.out.println(llq);

        System.out.println( llq.getFront());

    }
}
