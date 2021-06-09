package com.jason.structure.linearity.array;

/**
 * 三角矩阵.
 * <pre>
 *  三角矩阵分为上三角矩阵和下三角矩阵。
 *      上三角矩阵以行优先顺序存储。
 *      下三角矩阵以列优先顺序存储。
 * </pre>
 *
 * @author WangChenHol
 * @date 2021/6/4 16:35
 **/
public class TriangularMatrix extends IArray {

    private boolean isLowerTriangularMatrix = true; // 是否是下三角矩阵，默认是下三角矩阵

    public TriangularMatrix(int sideLength) {
        this.sideLength = sideLength;
        element = new Object[getElementLength()];
    }

    public TriangularMatrix(int sideLength, boolean isLowerTriangularMatrix) {
        this.sideLength = sideLength;
        element = new Object[getElementLength()];
        this.isLowerTriangularMatrix = isLowerTriangularMatrix;
    }

    /**
     * 根据矩阵的边长获取存放数据的数组长度
     */
    private int getElementLength() {
        return sideLength * (sideLength + 1) / 2;
    }

    @Override
    public int length() {
        return element.length;
    }

    @Override
    public Object getValue(int index) {
        return null;
    }

    @Override
    public Object getValue(int line, int row) throws Exception {
        checkIndex(line, row);
        Object value = element[getIndex(line, row)];
        value = changeValue(line, row, value);
        return value;
    }

    /**
     * 如果存储位置不符合三角矩阵的规则，则将存储的数据元素置为0存储。
     *
     * @param line  行坐标
     * @param row   列坐标
     * @param value 数据元素
     * @return 最终存储的数据
     */
    private Object changeValue(int line, int row, Object value) {
        if (isLowerTriangularMatrix && row > line) {
            value = 0;
        }
        if (!isLowerTriangularMatrix && line > row) {
            value = 0;
        }
        return value;
    }

    @Override
    public void assign(Object value, int index) {
        // 不做任何操作
    }

    @Override
    public void assign(Object value, int line, int row) throws Exception {
        checkIndex(line, row);
        value = changeValue(line, row, value);
        int index = getIndex(line, row);
        element[index] = value;
        count++;
    }

    @Override
    public String displayValues() throws Exception {
        StringBuilder rs = new StringBuilder();
        for (int line = 0; line < sideLength; line++) {
            rs.append("|\t");
            for (int row = 0; row < sideLength; row++) {
                Object value = getValue(line, row);
                rs.append(value == null ? "" : value).append("\t");
            }
            rs.append("|\r\n");
        }
        return rs.toString();
    }

    private void checkIndex(int line, int row) throws Exception {
        if (line < 0 || row < 0 || line > sideLength - 1 || row > sideLength - 1) {
            throw new Exception("矩阵下标不合法");
        }
    }

    /**
     * 根据矩阵的坐标计算出在数组中的下标。
     *
     * @param line 横坐标
     * @param row  竖坐标
     * @return 数组下标
     */
    @Override
    protected int getIndex(int line, int row) {
        if (isLowerTriangularMatrix) {
            return line * (line + 1) / 2 + row;
        } else {
            return row * (row + 1) / 2 + line;
        }
    }
}
