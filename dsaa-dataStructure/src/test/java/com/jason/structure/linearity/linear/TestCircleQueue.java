package com.jason.structure.linearity.linear;

import com.jason.structure.linearity.queue.CircleQueue;
import org.junit.Test;

/**
 * @author WangChenHol
 * @date 2021/3/4 17:00
 **/
public class TestCircleQueue {

    @Test
    public void testCircleQueue() throws Exception {
        CircleQueue<String> queue = new CircleQueue<>(6);
        System.out.println(queue.length());
        System.out.println("队列是否满："+queue.isFull());
        System.out.println("队列是否空："+queue.isEmpty());
        queue.offer("aaa");
        queue.offer("bbb");
        queue.offer("ccc");
        System.out.println(queue.toString());
        System.out.println("循环队列的长度："+queue.length());
        System.out.println("循环队列的队首数据：："+queue.peek());
        System.out.println("出队：："+queue.poll());
        System.out.println(queue.toString());
        System.out.println("循环队列的长度："+queue.length());
        System.out.println("循环队列的队首数据：："+queue.peek());
        System.out.println("队列是否满："+queue.isFull());
        System.out.println("队列是否空："+queue.isEmpty());
        System.out.println("======================= 再次入队 =============");
        queue.offer("ddd");
        System.out.println(queue.toString());
        queue.offer("eee");
        System.out.println(queue.toString());
        queue.offer("fff");
        System.out.println(queue.toString());
        System.out.println("循环队列的长度："+queue.length());
        System.out.println("循环队列的队首数据：："+queue.peek());
        System.out.println("队列是否满："+queue.isFull());
        System.out.println("队列是否空："+queue.isEmpty());
        System.out.println("========== 出队两次 =======");
        queue.poll();
        System.out.println(queue.toString());
        queue.poll();
        System.out.println(queue.toString());
        System.out.println("======= 再次入队 =====");
        queue.offer("ggg");
        System.out.println(queue.toString());
        queue.offer("hhh");
        System.out.println(queue.toString());
        System.out.println("循环队列的长度："+queue.length());
        System.out.println("循环队列的队首数据：："+queue.peek());
        System.out.println("队列是否满："+queue.isFull());
        System.out.println("队列是否空："+queue.isEmpty());

    }
}
