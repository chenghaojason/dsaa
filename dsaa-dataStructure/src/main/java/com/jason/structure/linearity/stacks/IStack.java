package com.jason.structure.linearity.stacks;

/**
 * 栈的抽象数据类型
 *
 * @author ChenHol.Wong
 * @create 2021/2/16 11:37
 */
public interface IStack {

    /**
     * 将一个已经存在的栈置空
     */
    void clear();

    /**
     * 判断一个栈是否为空
     *
     * @return true:为空，false：不为空
     */
    boolean isEmpty();

    /**
     * 求栈中数据元素个数的操作
     *
     * @return 返回栈中数据元素的个数
     */
    int length();

    /**
     * 取栈顶数据元素
     *
     * @return 读取栈顶数据元素并返回其值，如果栈为空则返回null。
     */
    Object peek();

    /**
     * 入栈操作
     *
     * @param obj 将数据元素obj压入栈顶
     * @throws Exception 业务异常
     */
    void push(Object obj) throws Exception;

    /**
     * 出栈操作
     *
     * @return 删除并返回栈顶元素
     */
    Object pop();
}
