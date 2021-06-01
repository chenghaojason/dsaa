package com.jason.structure.linearity.string;

/**
 * 顺序串的抽象定义
 *
 * @author WangChenHol
 * @date 2021/3/9 17:40
 **/
public interface IString {
    /**
     * 串的置空：将一个已经存在的串置成空串。
     */
    void clear();

    /**
     * 判空：判断串是否是空串。
     *
     * @return true：空串
     */
    boolean isEmpty();

    /**
     * 求串长度：返回串中数据元素的个数。
     *
     * @return 串的长度
     */
    int length();

    /**
     * 取字符：返回串中第index个元素的值。
     *
     * @param index 序号
     * @return 此序号对应的字符
     */
    char charAt(int index);

    /**
     * 截取：返回串中第begin到end-1序号位置上的子串。前闭后开
     *
     * @param begin 起始位置
     * @param end   结束位置
     * @return 子串
     */
    IString substring(int begin, int end);

    /**
     * 插入：在当前串的第offset位置之后插入一个新的子串str。
     *
     * @param offset 插入的位置，从此位置插入新的串。offset的取值范围 0 <= offset <= length
     * @param str    新的串
     * @return 返回新的字符串
     */
    IString insert(int offset, IString str);

    /**
     * 删除：删除当前串中从第begin到end-1位置的子串。前闭后开
     *
     * @param begin 起始位置
     * @param end   结束位置
     * @return 被删除的子串
     */
    IString delete(int begin, int end);

    /**
     * 连接：把str串连接到当前串的后面。
     *
     * @param str 连接的对象
     * @return 新的串
     */
    IString concat(IString str);

    /**
     * 比较：比较两个串的值，如果等于0说明两个串完全相同。
     *
     * @param str 被比较的串
     * @return 0：两个串相同
     */
    int compareTo(IString str);

    /**
     * 去目标串的位置：在当前串中从begin位置开始搜索与str串相同的子串，如果存在则返回str在当前串中的位置，如果不存在则返回-1 。
     *
     * @param str   被搜索的字符串
     * @param begin 起始位置
     * @return 当前串的位置
     */
    int indexOf(IString str, int begin);

    char[] toCharArray();
}
