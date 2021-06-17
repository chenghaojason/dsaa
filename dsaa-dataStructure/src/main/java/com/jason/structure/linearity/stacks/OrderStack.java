package com.jason.structure.linearity.stacks;

/**
 * 顺序栈的操作实现
 *
 * @author WangChenHol
 * @date 2021/2/19 15:50
 **/
public class OrderStack implements IStack {

    private final Object[] stackElem; //存储数据元素的数组
    private int top; //指针。指向栈顶元素下一个存储单元的位置。
    private final int capacity; // 最大容量

    public OrderStack(int maxSize) {
        capacity = maxSize;
        stackElem = new Object[maxSize];
    }

    @Override
    public void clear() {
        top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int length() {
        return top;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return stackElem[top - 1];
    }

    @Override
    public void push(Object obj) throws Exception {
        if (capacity == top) {
            throw new Exception("栈已满");
        }
        stackElem[top++] = obj;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        int i = --top;
        Object o = stackElem[i];
        stackElem[i] = null;
        return o;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("OrderStack{");
        for (int i = 0; i < top; i++) {
            builder.append(stackElem[i]).append(" ");
        }
        builder.append("}");
        return builder.toString();
    }
}
