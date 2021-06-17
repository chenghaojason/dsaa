package com.jason.structure.linearity.stacks;

import com.jason.structure.nodes.Node;

/**
 * 链式栈的实现
 *
 * @author WangChenHol
 * @date 2021/3/3 14:51
 **/
public class LinkedStack implements IStack {

    private int length;
    private Node head;

    public LinkedStack() {

    }

    public LinkedStack(Object data) {
        head = new Node(data);
        length++;
    }

    @Override
    public void clear() {
        length = 0;
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public Object peek() {
        if (head == null) {
            throw new NullPointerException("此栈为空");
        }
        return head.data;
    }

    @Override
    public void push(Object obj) {
        Node node = new Node(obj);
        node.next = head;
        head = node;
        length++;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object data = head.data;
        head = head.next;
        length--;
        return data;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("LinkedStack{");
        Node next = head;
        while (next != null) {
            str.append(next.data).append(", ");
            next = next.next;
        }
        str.deleteCharAt(str.length() - 2);
        str.deleteCharAt(str.length() - 1);
        str.append("}");
        return str.toString();
    }
}

