package com.jason.structure.linearity.linear;

/**
 * 双向结点类
 *
 * @author WangChenHol
 * @date 2021/1/29 10:35
 **/
public class DoubleNode {
    public DoubleNode prev;
    public Object data;
    public DoubleNode next;

    public DoubleNode(Object data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public DoubleNode() {
        this(null);
    }
}
