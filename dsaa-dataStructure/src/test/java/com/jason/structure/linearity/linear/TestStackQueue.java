package com.jason.structure.linearity.linear;

import com.jason.structure.linearity.stacks.IStack;
import com.jason.structure.linearity.stacks.OrderStack;
import org.junit.Test;

/**
 * @author WangChenHol
 * @date 2021/2/19 16:14
 **/
public class TestStackQueue {

    @Test
    public void testOrderStack() throws Exception {
        IStack stack = new OrderStack(10);
        System.out.println("栈是否为空：" + stack.isEmpty());
        System.out.println("栈的长度：" + stack.length());
        System.out.println("栈顶元素：" + stack.peek());
        System.out.println("出栈：" + stack.pop());

        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
        stack.push(111);
        stack.push(222);
        stack.push(333);

        System.out.println("栈是否为空：" + stack.isEmpty());
        System.out.println("栈的长度：" + stack.length());
        System.out.println("栈顶元素：" + stack.peek());
        System.out.println("出栈：" + stack.pop());

        System.out.println(stack.toString());
        System.out.println("栈的长度：" + stack.length());
        stack.push(4444);
        stack.push(5555);
        stack.push(6666);
        stack.push(7777);
        stack.push(8888);
        System.out.println(stack.toString());
        System.out.println("栈的长度：" + stack.length());
        stack.push(1111111);
    }
}
