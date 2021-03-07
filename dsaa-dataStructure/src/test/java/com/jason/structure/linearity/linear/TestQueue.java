package com.jason.structure.linearity.linear;

import com.jason.structure.linearity.queue.CircleQueue;
import com.jason.structure.linearity.queue.LinkedQueue;
import org.junit.Test;

/**
 * 测试队列
 *
 * @author WangChenHol
 * @date 2021/3/4 17:00
 **/
public class TestQueue {

    /**
     * 测试循环顺序队列
     */
    @Test
    public void testCircleQueue() throws Exception {
        CircleQueue<String> queue = new CircleQueue<>(6);
        System.out.println(queue.length());
        System.out.println("队列是否满：" + queue.isFull());
        System.out.println("队列是否空：" + queue.isEmpty());
        queue.offer("aaa");
        queue.offer("bbb");
        queue.offer("ccc");
        System.out.println(queue.toString());
        System.out.println("循环队列的长度：" + queue.length());
        System.out.println("循环队列的队首数据：：" + queue.peek());
        System.out.println("出队：：" + queue.poll());
        System.out.println(queue.toString());
        System.out.println("循环队列的长度：" + queue.length());
        System.out.println("循环队列的队首数据：：" + queue.peek());
        System.out.println("队列是否满：" + queue.isFull());
        System.out.println("队列是否空：" + queue.isEmpty());
        System.out.println("======================= 再次入队 =============");
        queue.offer("ddd");
        System.out.println(queue.toString());
        queue.offer("eee");
        System.out.println(queue.toString());
        queue.offer("fff");
        System.out.println(queue.toString());
        System.out.println("循环队列的长度：" + queue.length());
        System.out.println("循环队列的队首数据：：" + queue.peek());
        System.out.println("队列是否满：" + queue.isFull());
        System.out.println("队列是否空：" + queue.isEmpty());
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
        System.out.println("循环队列的长度：" + queue.length());
        System.out.println("循环队列的队首数据：：" + queue.peek());
        System.out.println("队列是否满：" + queue.isFull());
        System.out.println("队列是否空：" + queue.isEmpty());

    }

    /**
     * 测试链式队列
     */
    @Test
    public void testLinkedQueue() throws Exception {
        LinkedQueue<String> queue = new LinkedQueue<>();
        System.out.println("链队列是否为空：" + queue.isEmpty());
        System.out.println("链队列的长度：" + queue.length());
        System.out.println(queue.toString());
        System.out.println("链队列的队首元素：" + queue.peek());
        System.out.println("============ 入队 =============");
        queue.offer("aaa");
        queue.offer("bbb");
        queue.offer("ccc");
        queue.offer("ddd");
        System.out.println(queue.toString());
        System.out.println("链队列是否为空：" + queue.isEmpty());
        System.out.println("链队列的长度：" + queue.length());
        System.out.println("链队列的队首元素：" + queue.peek());
        System.out.println("============ 出队 =============");
        System.out.println("出队的数据：" + queue.poll());
        System.out.println(queue.toString());
        System.out.println("链队列是否为空：" + queue.isEmpty());
        System.out.println("链队列的长度：" + queue.length());
        System.out.println("链队列的队首元素：" + queue.peek());
        System.out.println("============ 入队 =============");
        queue.offer("111");
        queue.offer("222");
        queue.offer("333");
        queue.offer("444");
        System.out.println(queue.toString());
        System.out.println("链队列是否为空：" + queue.isEmpty());
        System.out.println("链队列的长度：" + queue.length());
        System.out.println("链队列的队首元素：" + queue.peek());
        System.out.println("============ 出队 =============");
        System.out.println("出队的数据1：" + queue.poll());
        System.out.println("出队的数据2：" + queue.poll());
        System.out.println(queue.toString());
        System.out.println("链队列是否为空：" + queue.isEmpty());
        System.out.println("链队列的长度：" + queue.length());
        System.out.println("链队列的队首元素：" + queue.peek());
    }
}
