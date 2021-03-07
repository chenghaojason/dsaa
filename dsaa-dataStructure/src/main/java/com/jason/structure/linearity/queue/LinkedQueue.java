package com.jason.structure.linearity.queue;

import com.jason.structure.linearity.linear.Node;

/**
 * 链队列
 *
 * @author WangChenHol
 * @date 2021/3/5 13:52
 **/
public class LinkedQueue<T> implements IQueue<T> {
    private int length; // 队列中数据元素个数
    private Node front; // 指向队列的队首
    private Node tail; // 指向队列的队尾

    public LinkedQueue() {
        front = tail = null;
        length = 0;
    }

    @Override
    public void clear() {
        front = tail = null;
        length = 0;
    }

    @Override
    public boolean isEmpty() {
        return length == 0 || front == null; // 这里任何一个条件都可以判断链队列是否为空
    }

    @Deprecated
    @Override
    public boolean isFull() throws Exception {
        throw new Exception("链队列无需判断存储空间是否存满");
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public T peek() {
        if (front == null) {
            return null;
        }
        return (T) front.data;
    }

    /**
     * 如果队列为空，则队首和队尾就等于新入队的元素位置。如果队列不为空，则改变队尾的指向
     *
     * @param data 数据
     * @throws Exception 异常
     */
    @Override
    public void offer(T data) throws Exception {
        Node node = new Node(data);
        if (isEmpty()) {
            front = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    @Override
    public T poll() {
        if (front == null) {
            return null;
        } else {
            length--;
            T data = (T) front.data;
            front = front.next;
            return data;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder().append("LinkedQueue：{");
        Node node = front;

        while (node != null) {
            builder.append(node.data).append(", ");
            node = node.next;
        }
        if (front != null) {
            builder.deleteCharAt(builder.length() - 2);
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.append("}").toString();
    }
}
