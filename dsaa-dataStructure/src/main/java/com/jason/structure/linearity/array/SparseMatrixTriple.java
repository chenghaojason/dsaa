package com.jason.structure.linearity.array;

import com.jason.structure.nodes.TripleNode;

/**
 * 稀疏矩阵的三元组存储。以行序优先顺序存储稀疏矩阵中的元素。
 *
 * @author WangChenHol
 * @date 2021/6/9 14:07
 **/
public class SparseMatrixTriple {

    public TripleNode[] datas; // 三元组表
    public int rows; // 行数
    public int cloumns; // 列数
    public int nums; // 非零元素个数

    /**
     * 默认三元组大小为16
     */
    public SparseMatrixTriple() {
        this(16);
    }

    public SparseMatrixTriple(int maxSize) {
        datas = new TripleNode[maxSize];
        rows = 0;
        cloumns = 0;
        nums = 0;
    }

    /**
     * 初始化三元组顺序表
     *
     * @param mat 稀疏矩阵
     */
    public SparseMatrixTriple(int[][] mat) {
        int i, j, k = 0, count = 0;
        rows = mat.length;
        cloumns = mat[0].length;
        for (i = 0; i < mat.length; i++) {
            for (j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0) {
                    count++;
                }
            }
        }
        nums = count;
        datas = new TripleNode[nums];
        for (i = 0; i < mat.length; i++) {
            for (j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0) {
                    datas[k] = new TripleNode(i, j, mat[i][j]);
                    k++;
                }
            }
        }
    }

    /**
     * 给稀疏矩阵赋值
     *
     * @param row    行坐标
     * @param column 列坐标
     * @param value  值
     */
    public void assign(int row, int column, Object value) {
        // 先判断三元组是否需要扩容
        if (nums == 16) {
            int i = nums >> 1;
            int copyCount = i + nums;
            TripleNode[] copyDatas = new TripleNode[copyCount];
            System.arraycopy(datas, 0, copyDatas, 0, nums);
            datas = copyDatas;
        }

        // 将数据元素存储在三元组中
        TripleNode node = new TripleNode(row, column, value);
        datas[nums] = node;
        this.rows = Math.max(rows, (row + 1));
        this.cloumns = Math.max(cloumns, (cloumns + 1));
        nums++;
    }

    /**
     * 打印
     */
    public String display() {
        StringBuilder builder = new StringBuilder("稀疏矩阵三元组表存储结构：");
        builder.append("行数：").append(rows).append("  列数：").append(cloumns).append("  非0元素个数：").append(nums);
        builder.append("\r\n行  列  值\r\n");
        for (int i = 0; i < nums; i++) {
            builder.append(datas[i].row).append("\t").append(datas[i].column).append("\t").append(datas[i].value).append("\r\n");
        }
        builder.append("稀疏矩阵展示图：\r\n");
        int index = 0;
        for (int i = 0; i < rows; i++) {
            builder.append("|\t");
            for (int j = 0; j < cloumns; j++) {
                TripleNode data = datas[index];
                if (i == data.row && j == data.column) {
                    builder.append(data.value);
                    index++;
                } else {
                    builder.append(0);
                }
                builder.append("\t");
            }
            builder.append("|\r\n");

        }
        return builder.toString();
    }
}
