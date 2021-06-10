package com.jason.structure.linearity.array;

import com.jason.structure.nodes.OrthogonalListNode;

/**
 * 稀疏矩阵的十字链表存储
 *
 * @author WangChenHol
 * @date 2021/6/9 16:53
 **/
public class SparseMatrixOrthogonalList {

    public int rows; // 行数
    public int columns; // 列数
    public int nums; // 元素个数
    public OrthogonalListNode[] rowHead; // 行指针数组
    public OrthogonalListNode[] columnHead; // 列指针数组

    public SparseMatrixOrthogonalList(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.rowHead = new OrthogonalListNode[rows];
        this.columnHead = new OrthogonalListNode[columns];

//        for (int i = 0; i < rows; i++) {
//            rowHead[i] = new OrthogonalListNode();
//        }
//        for (int j = 0; j < columns; j++) {
//            columnHead[j] = new OrthogonalListNode();
//        }
    }

    public void assign(int row, int column, Object value) throws Exception {
        if (row > rows - 1 || column > columns - 1) {
            throw new Exception("坐标不合法");
        }
        OrthogonalListNode rowNode = rowHead[row];
        OrthogonalListNode columnNode = columnHead[column];
        OrthogonalListNode newNode = new OrthogonalListNode(row, column, value);
        // 在行上添加新元素
        if (rowNode == null) {
            rowHead[row] = newNode;
        } else {
            int frontColumn = rowNode.column;
            if (frontColumn > column) {
                newNode.right = rowNode;
                rowHead[row] = newNode;
            } else if (frontColumn == column) {
                newNode.right = rowNode.right;
                newNode.down = rowNode.down;
                rowHead[row] = newNode;
            } else {

                while (frontColumn < column && rowNode.right != null && column > rowNode.right.column) {
                    rowNode = rowNode.right;
                    frontColumn = rowNode.column;
                }
                newNode.right = rowNode.right;
                rowNode.right = newNode;
            }
        }
        // 在列上添加新元素
        if (columnNode == null) {
            columnHead[column] = newNode;
        } else {
            int frontRow = columnNode.row;

            if (frontRow > row) {
                newNode.down = columnNode;
                columnHead[column] = newNode;
            } else if (frontRow == row) {
                newNode.down = columnNode.down;
                newNode.right = columnNode.right;
                columnHead[column] = newNode;
            } else {
                while (frontRow < row && columnNode.down != null && row > columnNode.down.row) {
                    columnNode = columnNode.down;
                    frontRow = columnNode.row;
                }
                newNode.down = columnNode.down;
                columnNode.down = newNode;
            }
        }
        nums++;
    }

    public String display() {
        StringBuilder builder = new StringBuilder("稀疏矩阵十字链表存储结构：\r\n");
        builder.append("总行数：").append(rows).append("  总列数：").append(columns).append("  元素总数：").append(nums).append("\r\n");
        builder.append("\t行链表：\r\n");
        for (int i = 0; i < rowHead.length; i++) {
            builder.append("\t\t第 ").append(i).append(" 行非零元素为：");
            OrthogonalListNode node = rowHead[i];
            if (node != null) {
                while (node != null) {
                    builder.append(node.value).append(" ");
                    node = node.right;
                }
            } else {
                builder.append("无");
            }
            builder.append("\r\n");
        }
        builder.append("\t列链表：\r\n");
        for (int j = 0; j < columnHead.length; j++) {
            builder.append("\t\t第 ").append(j).append(" 列非零元素为：");
            OrthogonalListNode node = columnHead[j];
            if (node != null) {
                while (node != null) {
                    builder.append(node.value).append(" ");
                    node = node.down;
                }
            } else {
                builder.append("无");
            }
            builder.append("\r\n");
        }

        builder.append("稀疏矩阵展示图:\r\n");
        builder.append("\t行链表数据：\r\n");
        for (OrthogonalListNode node : rowHead) {
            builder.append("\t\t|\t");
            for (int i = 0; i < columnHead.length; i++) {
                if (node != null && node.column == i) {
                    builder.append(node.value).append("\t");
                    node = node.right;
                } else {
                    builder.append(0).append("\t");
                }
            }
            builder.append("|\r\n");
        }
//        builder.append("\t列链表数据：\r\n");
//        for (OrthogonalListNode node : columnHead) {
//            builder.append("|\t");
//            for (int j = 0; j < rowHead.length; j++) {
//                if (node != null) {
//                    builder.append(node.value).append("\t");
//                    node = node.down;
//                } else {
//                    builder.append(0).append("\t");
//                }
//            }
//            builder.append("|\r\n");
//        }

        return builder.toString();
    }


}
