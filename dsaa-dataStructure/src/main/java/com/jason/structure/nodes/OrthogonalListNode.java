package com.jason.structure.nodes;

/**
 * 十字链表结点结构
 *
 * @author WangChenHol
 * @date 2021/6/9 16:43
 **/
public class OrthogonalListNode {

    public int row; // 元素的行号
    public int column; // 元素的列号
    public Object value; // 元素的值
    public OrthogonalListNode right; // 行链表指针
    public OrthogonalListNode down; // 列链表指针

    public OrthogonalListNode(int row, int column, Object value) {
        this.row = row;
        this.column = column;
        this.value = value;
        this.right = null;
        this.down = null;
    }

    public OrthogonalListNode() {
        this(0, 0, 0);
    }
}
