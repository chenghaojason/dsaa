package com.jason.structure.linearity.array;

/**
 * 对称矩阵。
 * 对称线a00,a11,a22,a33,...,ann
 *
 * @author WangChenHol
 * @date 2021/6/4 14:27
 **/
public class SymmetricMatrix implements IArray {

    private final Object[] array; // 存放元素的数组
    private final int sideLength; // 边长 n * n
    private int times; // 操作次数

    public SymmetricMatrix(int sideLength) {
        this.sideLength = sideLength;
        int length = sideLength * (sideLength + 1) / 2;
        array = new Object[length];
    }

    @Override
    public int length() {
        return times;
    }

    @Override
    public Object getValue(int index) {
        return null;
    }

    @Override
    public Object getValue(int line, int row) throws Exception {
        checkIndex(line, row);
        return array[getIndex(line, row)];
    }

    @Override
    public void assign(Object value, int index) {
        // 不做任何操作
    }

    /**
     * 主要操作，对称矩阵的压缩存储算法
     *
     * @param value 存储的值
     * @param line  行
     * @param row   列
     * @throws Exception 当存储时行或者列取值范围不合法时抛出异常
     */
    @Override
    public void assign(Object value, int line, int row) throws Exception {
        checkIndex(line, row);
        int index = getIndex(line, row);
        array[index] = value;
        times++;
    }

    @Override
    public Object[] getArray() {
        return array;
    }

    private int getIndex(int line, int row) {
        if (line >= row) {
            return line * (line + 1) / 2 + row;
        } else {
            return row * (row + 1) / 2 + line;
        }
    }

    @Override
    public String toString() {
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < sideLength; i++) {
            rs.append("|\t");
            for (int j = 0; j < sideLength; j++) {
                Object obj = array[getIndex(i, j)];
                rs.append(obj == null ? "" : obj.toString()).append("\t");
            }
            rs.append("|\r\n");
        }
        return rs.toString();
    }

    public String values() {
        StringBuilder values = new StringBuilder();
        for (Object obj : array) {
            if (obj == null) {
                values.append(" ").append(", ");
            } else {
                values.append(obj.toString()).append(", ");
            }
        }
        return values.substring(0, values.length() - 2);
    }

    private void checkIndex(int line, int row) throws Exception {
        if (line < 0 || row < 0 || (line > sideLength - 1 || row > sideLength - 1)) {
            throw new Exception("矩阵下标不合法");
        }
    }
}
