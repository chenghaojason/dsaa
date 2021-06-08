package com.jason.structure.linearity.array;

/**
 * 数组操作.
 * 矩阵压缩操作接口
 *
 * @author WangChenHol
 * @date 2021/6/4 14:08
 **/
public abstract class IArray {

    protected Object[] element; // 存放元素的数组
    protected int sideLength; // 边长 n * n
    protected int count = 0; // 实际元素个数

    /**
     * 求数组长度
     *
     * @return 数组长度
     */
    public abstract int length();

    /**
     * 取值，一维数组
     *
     * @param index 下标
     * @return 值
     */
    public abstract Object getValue(int index);

    /**
     * 取值，二维数组
     *
     * @param line 行下标
     * @param row  列下标
     * @return 值
     */
    public abstract Object getValue(int line, int row) throws Exception;


    /**
     * 给数组赋值，一维数组
     *
     * @param value 值
     * @param index 下标
     */
    public abstract void assign(Object value, int index);

    /**
     * 给数组赋值，二维数组
     *
     * @param line 值
     * @param row  下标
     */
    public abstract void assign(Object value, int line, int row) throws Exception;

    /**
     * 获取压缩存储的二维数组
     *
     * @return 二维数组
     */
    public Object[] getElement() {
        return element;
    }

    public int getEleCount() {
        return count;
    }

    protected abstract int getIndex(int line, int row);

    /**
     * 将矩阵按照规则在页面展示出来
     *
     * @return 矩阵
     */
    public abstract String displayValues() throws Exception;


    @Override
    public String toString() {
        StringBuilder values = new StringBuilder();
        for (Object obj : element) {
            if (obj == null) {
                values.append(" ").append(", ");
            } else {
                values.append(obj.toString()).append(", ");
            }
        }
        return values.substring(0, values.length() - 2);
    }
}
