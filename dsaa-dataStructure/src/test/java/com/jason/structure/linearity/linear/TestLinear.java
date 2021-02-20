package com.jason.structure.linearity.linear;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 线性结构测试
 *
 * @author WangChenHol
 * @date 2021/1/29 10:46
 **/
public class TestLinear {

    /**
     * 测试顺序表
     */
    @Test
    public void TestOrderList() {
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
    }

    /**
     * 单链表
     *
     * @throws Exception 异常
     */
    @Test
    public void TestSingleLinkedList() throws Exception {
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
    }

    /**
     * 循环表（单链表）
     */
    @Test
    public void TestCirularLinkedList() throws Exception {
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

    /**
     * 测试双向链表
     */
    @Test
    public void testDoubleLinkedList() {
        try {
            DoubleLinkedList list = new DoubleLinkedList();
            System.out.println("============== 操作之前 ==============");
            System.out.println("是否为空：" + list.isEmpty());
            System.out.println("长度：" + list.length());

            list.insert(0, "000");
            list.display();
            list.insert(1, 111);
            list.display();
            list.insert(2, 222);
            list.display();
            list.insert(0, "00000");
            list.display();
            list.insert(1, "111111");
            list.display();
            list.add("aaa");
            list.add("bbb");
            list.display();
            list.insert(7,"cccccc");
            list.display();
            System.out.println("是否为空：" + list.isEmpty());
            System.out.println("长度：" + list.length());
            System.out.println("第3个元素："+list.get(3));
            System.out.println("aaa的位置："+list.indexOf("aaa"));
            System.out.println("删除第4个元素"+list.remove(4));
            list.display();
            System.out.println("长度：" + list.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test(){
        LinkedList<String> list = new LinkedList<>();
        list.add(0,"000");
        list.add(1,"111");
        list.add(2,"222");
        list.add(0,"000000");
        list.add(1,"111111");
        System.out.println(list.toString());
    }

    @Test
    public void test1(){
        System.out.println(1>>1);
        System.out.println(2>>1);
        System.out.println(3>>1);
        System.out.println(4>>1);
        System.out.println(5>>1);
        System.out.println(6>>1);
        System.out.println(7>>1);
        System.out.println(8>>1);
        System.out.println(9>>1);
    }
}
