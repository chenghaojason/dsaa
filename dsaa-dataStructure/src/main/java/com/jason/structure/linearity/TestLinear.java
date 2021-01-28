package com.jason.structure.linearity;

import com.jason.structure.linearity.linear.CirularLinkedList;
import com.jason.structure.linearity.linear.OrderList;
import com.jason.structure.linearity.linear.SingleLinkedList;

/**
 * @author WangChenHol
 * @date 2021/1/21 15:42
 **/
public class TestLinear {
    public static void main(String[] args) throws Exception {
        System.out.println("============== 顺序表 ====================");
        OrderList list = new OrderList(10);
        list.insert(0, "aaa");
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        list.add("666");
        list.add("777");
        list.add("888");
        list.add("999");

        list.display();

        System.out.println(list.get(3));
        System.out.println(list.length());
        System.out.println(list.indexOf("777"));
        System.out.println(list.remove(2));
        list.display();
        System.out.println(list.length());


        System.out.println("============== 单链表 ====================");
        SingleLinkedList linkList = new SingleLinkedList(true);
        linkList.insert(0, "aaa");
        linkList.insert(1, "bbb");
        linkList.insert(1, "ccc");

        linkList.display();
        System.out.println("ccc的位置：" + linkList.indexOf("ccc"));
        System.out.println("第2个是：" + linkList.get(2));
        System.out.println("移除第0个是：" + linkList.remove(0));
        linkList.display();

        linkList.add("111");
        linkList.add("222");
        linkList.add("333");
        linkList.display();
        System.out.println(linkList.length());

        System.out.println("============== 循环链表 ====================");
        CirularLinkedList cirularLinkedList = new CirularLinkedList();
        cirularLinkedList.insert(0, "aaa");
        cirularLinkedList.display();
        cirularLinkedList.insert(1, "bbb");
        cirularLinkedList.display();
        cirularLinkedList.insert(0, "ccc");
        cirularLinkedList.display();
        cirularLinkedList.insert(1, "ddd");
        cirularLinkedList.display();
        cirularLinkedList.insert(4, "eee");
        cirularLinkedList.display();
        cirularLinkedList.insert(4, "fff");
        cirularLinkedList.display();
        cirularLinkedList.insert(4, "ggg");
        cirularLinkedList.display();
        cirularLinkedList.add("111");
        cirularLinkedList.add("222");
        cirularLinkedList.add("333");
        cirularLinkedList.add("444");
        cirularLinkedList.display();
        System.out.println("第2个元素：" + cirularLinkedList.get(2));
        System.out.println("链表长度：" + cirularLinkedList.length());
        System.out.println("链表是否为空：" + cirularLinkedList.isEmpty());
        System.out.println("元素 222 的位置：" + cirularLinkedList.indexOf("222"));
        System.out.println("删除第0个元素：" + cirularLinkedList.remove(0));
        cirularLinkedList.display();
        System.out.println(cirularLinkedList.length());
        System.out.println("删除第3个元素：" + cirularLinkedList.remove(3));
        cirularLinkedList.display();
        System.out.println("第2个元素：" + cirularLinkedList.get(2));
        System.out.println("链表的长度：" + cirularLinkedList.length());
    }
}
