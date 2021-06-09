package com.jason.structure.linearity.array;

import java.util.Arrays;

/**
 * 对角矩阵
 * （以行优先顺序存储）
 *
 * @author WangChenHol
 * @date 2021/6/8 15:09
 **/
public class DiagonalMatrix extends IArray {

    private final int bandWidth; // 半带宽，带宽为2*bandwidth + 1 。就是除对角线外上方或者下方不为0的对角线数。

    public DiagonalMatrix(int sideLength) throws Exception {
        this.sideLength = sideLength;
        this.bandWidth = 0;
        element = new Object[getElementLength()];
        supplement();
    }

    public DiagonalMatrix(int sideLength, int bandWidth) throws Exception {
        this.sideLength = sideLength;
        this.bandWidth = bandWidth;
        element = new Object[getElementLength()];
        supplement();
    }

    private int getElementLength() {
        return sideLength * (2 * bandWidth + 1);
    }

    /**
     * 为了计算方便，认为每一行都有2*bandWidth+1个元素，如果不足的话用0补充
     */
    private void supplement() throws Exception {
        Arrays.fill(element, 0);
    }

    public int getBandWidth() {
        return bandWidth;
    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public Object getValue(int index) {
        return null;
    }

    @Override
    public Object getValue(int line, int row) throws Exception {
        checkIndex(line, row);
        if (Math.abs(line - row) > bandWidth) {
            return 0;
        }
        return element[getIndex(line, row)];
    }

    private void checkIndex(int line, int row) throws Exception {
        if (line < 0 || row < 0 || line > sideLength - 1 || row > sideLength - 1) {
            throw new Exception("对角矩阵下标不合法");
        }
    }

    @Override
    public void assign(Object value, int index) {

    }

    @Override
    public void assign(Object value, int line, int row) throws Exception {
        int index = getIndex(line, row);
        if (Math.abs(line - row) > bandWidth) {
            throw new Exception("对角矩阵下标不合法");
        }
        element[index] = value;
        count++;
    }

    @Override
    protected int getIndex(int line, int row) throws Exception {
        checkIndex(line, row);
        // 根据对角矩阵的压缩规律得出数据元素压缩存储在一位数组中的位置。
        return line * (2 * bandWidth + 1) + bandWidth + (row - line);
    }

    private int getIndex(int line, int row, int bandWidth) throws Exception {
        checkIndex(line, row);
        // 根据对角矩阵的压缩规律得出数据元素压缩存储在一位数组中的位置。
        return line * (2 * bandWidth + 1) + bandWidth + (row - line);
    }

    @Override
    public String displayValues() throws Exception {
        StringBuilder rs = new StringBuilder("对称三角矩阵展示图：\r\n");
        for (int line = 0; line < sideLength; line++) {
            rs.append("|\t");
            for (int row = 0; row < sideLength; row++) {
                Object value = getValue(line, row);
                rs.append(value == null ? "*" : value).append("\t");
            }
            rs.append("|\r\n");
        }
        return rs.toString();
    }
}
