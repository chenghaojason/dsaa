package com.jason.structure.linearity.linear;

import com.jason.structure.nodes.Node;

/**
 * 循环链表，使用头指针来标识循环链表
 *
 * @author WangChenHol
 * @date 2021/1/27 11:13
 **/
public class CirularLinkedList implements LinearList {

    public static final String MSG = "位置不合法";
    public final Node head;// 尾指针
    private int size;

    public CirularLinkedList() {
        head = new Node();
        head.data = null;
        head.next = head;
    }

    @Override
    public void clear() {
        head.next = head;
        head.data = null;
    }

    @Override
    public boolean isEmpty() {
        return head.next == head;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public Object get(int i) throws Exception {

        if (!(i >= 0 && i < size)) {
            throw new IndexOutOfBoundsException(MSG);
        }
        int len = 0;
        Node node = head.next;
        while (len < i) {
            node = node.next;
            len++;
        }
        if (node == null) {
            throw new Exception(MSG);
        }
        return node.data;
    }

    @Override
    public void insert(int i, Object e) throws Exception {
        if (!(i >= 0 && i <= size)) {
            throw new IndexOutOfBoundsException(MSG);
        }
        Node add = new Node(e);
        int index = -1;
        Node temp = head;
        if (i == 0) {
            // 插入头部
            add.next = head.next;
            head.next = add;
        } else if (i == size) {
            // 插入尾部
            while (index + 1 < i) {
                temp = temp.next;
                index++;
            }
            temp.next = add;
            add.next = head;
        } else {
            // 插入中间
            while (index < i - 1) {
                temp = temp.next;
                index++;
            }
            add.next = temp.next;
            temp.next = add;
        }
        size++;
    }

    @Override
    public void add(Object object) {
        // 添加到尾部
        Node node = new Node(object);

        if (head.next == head) {
            head.next = node;
            node.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = node;
            node.next = head;
        }

        size++;
    }

    @Override
    public Object remove(int i) throws Exception {

        if (!(i >= 0 && i < size)) {
            throw new IndexOutOfBoundsException(MSG);
        }
        int index = -1;
        Node node = head;
        // 先找出删除元素的前驱
        while (index < i - 1) {
            node = node.next;
            index++;
        }
        if (node == null || node.next == null) {
            throw new Exception("数据异常");
        }
        Object data = node.next.data;
        node.next = node.next.next;
        size--;
        return data;
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        Node temp = head;
        while (temp.next != head) {
            if (temp.next.data.equals(e)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    @Override
    public String display() throws Exception {
        StringBuilder str = new StringBuilder();
        str.append("[");
        Node temp = head;
        while (temp.next != head) {
            str.append(temp.next.data).append(", ");
            temp = temp.next;
        }
        str.deleteCharAt(str.length() - 2);
        str.deleteCharAt(str.length() - 1);
        str.append("]");
        return str.toString();
    }
}
