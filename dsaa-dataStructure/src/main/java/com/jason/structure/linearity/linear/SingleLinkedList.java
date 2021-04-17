package com.jason.structure.linearity.linear;

/**
 * 单链表实现
 *
 * @author WangChenHol
 * @date 2021/1/22 14:24
 **/
public class SingleLinkedList implements LinearList {

    public final Node head; // 头指针。线性表的第一个结点的存储地址称为头指针。
    private boolean order = false; // true：头插法，false：尾插法

    public SingleLinkedList() {
        head = new Node(); // 初始化头结点
    }

    public SingleLinkedList(boolean order) {
        this();
        this.order = order;
    }

    @Override
    public void clear() {
        head.data = null;
        head.next = null;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public int length() {
        Node node = head.next;
        int length = 0;
        while (node != null) {
            node = node.next;
            ++length;
        }
        return length;
    }

    @Override
    public Object get(int i) throws Exception {
        int len = 0;
        Node next = head.next;
        while (next != null && len < i) {
            next = next.next;
            ++len;
        }
        if (next == null || len > i) {
            throw new Exception("元素不存在");
        }
        return next.data;
    }

    @Override
    public void insert(int i, Object e) throws Exception {
        Node node = head;
        int index = -1;
        while (node != null && index < i - 1) { // 找到第i个结点的前驱
            node = node.next;
            ++index;
        }
        if (node == null || index > i - 1) {
            throw new Exception("位置不合法");
        }
        Node add = new Node(e);
        // 下面两行顺序不能颠倒
        add.next = node.next;
        node.next = add;
    }

    @Override
    public void add(Object object) {
        Node node = new Node(object);
        if (order) {// 头插法
            Node next = head.next;
            head.next = node;
            node.next = next;
        } else { // 尾插法
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
    }

    @Override
    public Object remove(int i) throws Exception {
        Node node = head;
        int len = -1;
        while (node.next != null && len < i - 1) { // 找到第i个结点的前驱结点
            node = node.next;
            ++len;
        }
        if (len > i - 1 || node.next == null) {
            throw new Exception("删除的位置不合法");
        }
        Object data = node.next.data; // 被删除的数据
        node.next = node.next.next; // 修改指针链接，释放被删除的数据元素
        return data;
    }

    @Override
    public int indexOf(Object e) {
        int len = 0;
        Node node = head.next;
        while (node != null && !node.data.equals(e)) {
            node = node.next;
            ++len;
        }
        if (node != null) {
            return len;
        } else {
            return -1;
        }
    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node node = head.next;
        extracted(sb, node);
        return sb.toString();
    }

    private void extracted(StringBuilder sb, Node node) {
        while (node != null) {
            sb.append(node.data).append(", ");
            node = node.next;
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
    }
}
