package com.jason.structure.linearity.linear;

import java.util.Objects;

/**
 * 双向链表(非循环)
 *
 * @author WangChenHol
 * @date 2021/1/29 10:37
 **/
public class DoubleLinkedList implements LinearList {
    public final DoubleNode head;
    private int size;

    public DoubleLinkedList() {
        head = new DoubleNode();
    }

    @Override
    public void clear() {
        head.data = null;
        head.prev = null;
        head.next = null;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public Object get(int i) {
        return findNodeByIndex(i).data;
    }

    @Override
    public void insert(int i, Object e) throws Exception {
        if (!(i >= 0 && i <= size)) {
            throw new IndexOutOfBoundsException("位置不合法");
        }
        DoubleNode add = new DoubleNode(e);
        if (i == size) {
            // 添加表尾部
            DoubleNode next = this.head;
            while (next.next != null) {
                next = next.next;
            }
            next.next = add;
            add.prev = next;
        } else {
            // 插入表中间
            DoubleNode next = head.next;
            int index = 0;
            while (index < i) {
                next = next.next;
                index++;
            }
            add.next = next;
            add.prev = next.prev;
            next.prev.next = add;
            next.prev = add;
        }

        size++;

    }

    // 将数据添加到表尾
    @Override
    public void add(Object object) {
        DoubleNode add = new DoubleNode(object);
        DoubleNode next = head;
        while (next.next != null) {
            next = next.next;
        }
        next.next = add;
        add.prev = next;
        size++;
    }

    @Override
    public Object remove(int i) {
        DoubleNode next = findNodeByIndex(i);
        Object data = next.data;
        next.next.prev = next.prev;
        next.prev.next = next.next;
        size--;
        return data;
    }

    private DoubleNode findNodeByIndex(int i) {
        if (!(i >= 0 && i < size)) {
            throw new IndexOutOfBoundsException("位置不合法");
        }
        int index = 0;
        DoubleNode next = head.next;
        while (index < i) {
            next = next.next;
            index++;
        }
        if (next == null) {
            throw new NullPointerException("数据不存在");
        }
        return next;
    }

    @Override
    public int indexOf(Object e) {
        DoubleNode next = head.next;
        int index = 0;
        while (next != null) {
            if (next.data == null && e == null) {
                return index;
            }
            if (Objects.equals(next.data, e)) {
                return index;
            }
            next = next.next;
            index++;
        }
        return -1;
    }

    @Override
    public void display() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        DoubleNode next = head.next;
        extracted(sb, next);
        System.out.println("双向链表：" + sb.toString());
    }

    private void extracted(StringBuilder sb, DoubleNode next) {
        while (next != null) {
            sb.append(next.data).append(", ");
            next = next.next;
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.deleteCharAt(sb.length() - 1).append("]");
    }
}
