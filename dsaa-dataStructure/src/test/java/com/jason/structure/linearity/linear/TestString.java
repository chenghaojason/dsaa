package com.jason.structure.linearity.linear;

import com.jason.structure.linearity.string.OrderString;
import org.junit.Test;

/**
 * @author WangChenHol
 * @date 2021/3/10 10:58
 **/
public class TestString {

    @Test
    public void testOrderString() {
        OrderString string = new OrderString();

        System.out.println(string.toString());
        System.out.println("字符串是否为空：" + string.isEmpty() + "  字符串的长度：" + string.length());

        System.out.println(string.insert(0, new OrderString("ABC")));
        System.out.println("字符串是否为空：" + string.isEmpty() + "  字符串的长度：" + string.length());

        System.out.println(string.insert(0, new OrderString("123")));
        System.out.println("字符串是否为空：" + string.isEmpty() + "  字符串的长度：" + string.length());

        System.out.println(string.insert(3, new OrderString("456")));
        System.out.println(string.insert(9, new OrderString("DEF")));
        System.out.println(string.charAt(6));
        System.out.println("截取：" + string.substring(2, 5).toString());
        System.out.println(string.toString());
        System.out.println("删除：" + string.delete(6, 12).toString());
        System.out.println(string.toString());

        string.concat(new OrderString("abcdef"));
        System.out.println(string.toString());

        System.out.println(string.compareTo(new OrderString("123456abcdef")));
        System.out.println(string.compareTo(new OrderString("123456abcdefghi")));
        System.out.println(string.compareTo(new OrderString("123456")));
        System.out.println(string.compareTo(new OrderString("123456QQQQQ")));
    }

    @Test
    public void testIndexOf() {
        // 测试indexOf方法
        OrderString test = new OrderString("abcababcdaaaaa");
        System.out.println("下标：" + test.indexOf(new OrderString("abcd"), 0));
        System.out.println("下标：" + test.indexOf(new OrderString("abc"), 0));
        System.out.println("下标：" + test.indexOf(new OrderString("ab"), 0));
        System.out.println("下标：" + test.indexOf(new OrderString("aaaaa"), 0));
        System.out.println("测试从不同的位置开始搜索");
        System.out.println("下标：" + test.indexOf(new OrderString("abcd"), 2));
        System.out.println("下标：" + test.indexOf(new OrderString("abcd"), 5));
        System.out.println("下标：" + test.indexOf(new OrderString("abcd"), 6));
        System.out.println("下标：" + test.indexOf(new OrderString("aaaaa"), 1));
        System.out.println("下标：" + test.indexOf(new OrderString("aaaaa"), 8));
        System.out.println("下标：" + test.indexOf(new OrderString("aaaaa"), 9));
        System.out.println("下标：" + test.indexOf(new OrderString("aaaaa"), 10));
        System.out.println("测试下标越界");
        System.out.println("下标：" + test.indexOf(new OrderString("abcdefghijklmnopqrstuvwxyz"), 0));
        System.out.println("下标：" + new OrderString("aaaaa").indexOf(new OrderString("aa"), 1));
        System.out.println("下标：" + new OrderString("aaaaa").indexOf(new OrderString("aaaaa"), 1));
        System.out.println("下标：" + new OrderString("aaaaa").indexOf(new OrderString("aaaaaaa"), 1));
        System.out.println("测试特殊情况");
        System.out.println("下标：" + new OrderString("bbbcbbbbc").indexOf(new OrderString("bbbbc"), 0));
        System.out.println("下标：" + new OrderString("bbbcbbbbc").indexOf(new OrderString("bbbbc"), 1));
        System.out.println("下标：" + new OrderString("bbbcbbbbc").indexOf(new OrderString("bbbbc"), 5));


    }

    @Test
    public void testKMP() {
        OrderString string = new OrderString("");
        int[] next = string.getNext(new OrderString("bbbbc"));
        for (int n : next) {
            System.out.print(n + " ");
        }
        System.out.println("");
        int[] nextVal = string.getNextVal(new OrderString("bbbbc"));
        for (int n : nextVal) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
