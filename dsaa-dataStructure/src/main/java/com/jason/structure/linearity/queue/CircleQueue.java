package com.jason.structure.linearity.queue;

/**
 * 循环队列的实现。
 * </br>
 * 在此循环队列中，采用空出一个存储存储单元的方式来判断队列是空还是满状态。
 * <pre>
 *     在循环队列中不断的做入队和出队的操作后，空出来的存储单元的位置也在不断的变化，
 *     但是无论如何都会有一个存储单元是不存放任何数据的。
 * <pre/>
 * @author WangChenHol
 * @date 2021/3/4 16:12
 **/
public class CircleQueue<T> implements IQueue<T> {

    private Object[] queueElm; // 存储队列中数据元素值的数组
    private int length; // 队列的数据元素个数
    private int front; // 指向队首的数据元素位置，如果为空队列，则值为0
    private int tail; // 指向队尾的数据元素下一个的位置，如果空队列，则为0
    private final int maxSize; // 队列所存储元素的最大个数

    /**
     * 默认状态下队列的最大存储16个数据元素
     */
    public CircleQueue() {
        front = tail = 0;
        this.maxSize = 16;
        queueElm = new Object[16];
    }

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        front = tail = 0;
        queueElm = new Object[maxSize];
    }

    @Override
    public void clear() {
        queueElm = null;
        length = 0;
        front = tail = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public boolean isFull() {
        // 求摸（求余数）
        return front == (tail + 1) % maxSize;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) queueElm[front];
    }

    @Override
    public void offer(T data) throws Exception {
        if (isFull()) {
            throw new Exception("队列满了");
        }
        queueElm[tail] = data;
        tail = (tail + 1) % maxSize;
        length++;
    }

    @Override
    public T poll() {
        T t = (T) queueElm[front];
        queueElm[front]=null;
        front = (front + 1) % maxSize;
        length--;
        return t;
    }

    /**
     * 从队首到队尾打印队列中的元素值
     *
     * @return 字符串
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder().append("CircleQueue{");
        int index = front;
        for (int i = 0; i < length; i++) {
            builder.append(queueElm[index]).append(", ");
            index = (index + 1) % maxSize;
        }
        if (!isEmpty()) {
            builder.deleteCharAt(builder.length() - 2);
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("}");
        return builder.toString();
    }
}
