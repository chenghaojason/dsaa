package com.jason.structure.linearity.linear;

/**
 * @author WangChenHol
 * @date 2021/1/20 10:58
 * 线性表接口
 **/
public interface LinearList {
    /**
     * 将一个已经存在的线性表置为空表
     */
    void clear();

    /**
     * 判断线性表是否为空
     */
    boolean isEmpty();

    /**
     * 求线性表中元素的个数，并返回其值
     */
    int length();

    /**
     * 读取并返回线性表中的第i个数据元素的值。其中i的取值范围：0 <= i <= length()-1
     */
    Object get(int i) throws Exception;

    /**
     * 在线性表中的第i个数据元素之前插入一个值为e的数据元素。其中i的取值范围：0 <= i <= length()-1。<br/>
     * 当i =0 时，在表头插入e，当i = length()时，在表尾插入e。
     */
    void insert(int i, Object e) throws Exception;

    void add(Object object);

    /**
     * 删除并返回线性表中第i个数据元素。其中i的取值范围：0 <= i <= length()-1
     */
    Object remove(int i) throws Exception;

    /**
     * 返回线性表中首次出现指定数据元素e的位序号，如果线性表中不包含此数据则返回-1.
     */
    int indexOf(Object e);

    /**
     * 输出线性表中各个数据元素的值
     */
    void display();
}
