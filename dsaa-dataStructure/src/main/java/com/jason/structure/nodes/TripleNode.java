package com.jason.structure.nodes;

/**
 * 三元组结点类
 *
 * @author WangChenHol
 * @date 2021/6/9 13:54
 **/
public class TripleNode {
    public int row; // 行号
    public int column; // 列号
    public Object value; // 元素值

    public TripleNode(int row, int column, Object value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public TripleNode() {
    }
}
