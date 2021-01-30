package com.jason.structure.linearity.linear;

/**
 * 单向结点类
 *
 * @author WangChenHol
 * @date 2021/1/22 10:21
 **/
public class Node {
    public Object data; // 数据域，存放结点的值
    public Node next; // 后继结点的地址引用

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node(Node next) {
        this.next = next;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}
