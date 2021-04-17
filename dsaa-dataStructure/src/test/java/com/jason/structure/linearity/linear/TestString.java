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
        System.out.println("字符串是否为空：" + string.isEmpty());
        System.out.println("字符串的长度：" + string.length());

        string.insert(0, new OrderString("ABC"));
        System.out.println(string.toString());
        System.out.println("字符串是否为空：" + string.isEmpty());
        System.out.println("字符串的长度：" + string.length());

        string.insert(0, new OrderString("123"));
        System.out.println(string.toString());
        System.out.println("字符串是否为空：" + string.isEmpty());
        System.out.println("字符串的长度：" + string.length());

        string.insert(3, new OrderString("456"));
        System.out.println(string.toString());
        string.insert(9, new OrderString("DEF"));
        System.out.println(string.toString());
        System.out.println(string.charAt(6));
        System.out.println("截取："+string.substring(2,5).toString());
        System.out.println(string.toString());
        System.out.println("删除："+string.delete(6,12).toString());
        System.out.println(string.toString());

        string.concat(new OrderString("abcdef"));
        System.out.println(string.toString());

        System.out.println(string.compareTo(new OrderString("123456abcdef")));
        System.out.println(string.compareTo(new OrderString("123456abcdefghi")));
        System.out.println(string.compareTo(new OrderString("123456")));
        System.out.println(string.compareTo(new OrderString("123456QQQQQ")));

    }
}
