package com.jason.structure.linearity.array;

/**
 * 数组操作
 *
 * @author WangChenHol
 * @date 2021/6/4 14:08
 **/
public interface IArray {

    /**
     * 求数组长度
     *
     * @return
     */
    int length();

    /**
     * 取值，一维数组
     *
     * @param index 下标
     * @return 值
     */
    Object getValue(int index);

    /**
     * 取值，二维数组
     *
     * @param line 下标1
     * @param row  下标2
     * @return 值
     */
    Object getValue(int line, int row) throws Exception;


    /**
     * 给数组赋值，一维数组
     *
     * @param value 值
     * @param index 下标
     */
    void assign(Object value, int index);

    /**
     * 给数组赋值，二维数组
     *
     * @param line 值
     * @param row  下标
     */
    void assign(Object value, int line, int row) throws Exception;

    Object [] getArray();
}
