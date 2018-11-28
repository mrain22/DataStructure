package test;

import com.marvin.queue.IQueue;
import com.marvin.queue.LinkedListQueue;
import com.marvin.queue.LoopQueue;
import com.marvin.queue.ArrayQueue;

import java.util.Random;

/**
 * @Author: Marvin
 * @Date: 2018/11/21 20:34
 * @Version 1.0
 * @Describe:
 */
public class QueueTest {

    private static  double testQueue(IQueue<Integer> q, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }
    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue,time:"+time1+"s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue,time:"+time2+"s");

        LinkedListQueue<Integer> llq = new LinkedListQueue<>();
        double time3 = testQueue(llq, opCount);
        System.out.println("LinkedListQueue,time:"+time3+"s");

    }
}
