package com.jason.structure.linearity;

import com.jason.structure.linearity.linear.LinkList;
import com.jason.structure.linearity.linear.OrderList;

/**
 * @author WangChenHol
 * @date 2021/1/21 15:42
 **/
public class TestLinear {
    public static void main(String[] args) throws Exception {
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
        LinkList linkList = new LinkList(true);
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
}
