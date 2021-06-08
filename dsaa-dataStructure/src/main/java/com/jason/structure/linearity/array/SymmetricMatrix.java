package com.jason.structure.linearity.array;

/**
 * 对称矩阵。
 * <pre>
 *      对称线a00,a11,a22,a33,...,ann。
 *      以行优先顺序存储。
 * </pre>
 *
 * @author WangChenHol
 * @date 2021/6/4 14:27
 **/
public class SymmetricMatrix extends IArray {

    public SymmetricMatrix(int sideLength) {
        this.sideLength = sideLength;
        int length = sideLength * (sideLength + 1) / 2;
        element = new Object[length];
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
        return value;
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
        element[index] = value;
        count++;
    }

    /**
     * 很具矩阵的坐标获取压缩数组的下标
     *
     * @param line 横坐标
     * @param row  竖坐标
     * @return 数组的下标
     */
    @Override
    protected int getIndex(int line, int row) {
        if (line >= row) {
            return line * (line + 1) / 2 + row;
        } else {
            return row * (row + 1) / 2 + line;
        }
    }


    @Override
    public String displayValues() {
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < sideLength; i++) {
            rs.append("|\t");
            for (int j = 0; j < sideLength; j++) {
                Object obj = element[getIndex(i, j)];
                rs.append(obj == null ? "" : obj.toString()).append("\t");
            }
            rs.append("|\r\n");
        }
        return rs.toString();
    }

    private void checkIndex(int line, int row) throws Exception {
        if (line < 0 || row < 0 || (line > sideLength - 1 || row > sideLength - 1)) {
            throw new Exception("矩阵下标不合法");
        }
    }
}
