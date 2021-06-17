package com.jason.structure.nodes;

/**
 * 二叉链表结点
 *
 * @author WangChenHol
 * @date 2021/6/10 16:16
 **/
public class BinaryNode {

    public Object data; // 结点域的值
    public BinaryNode leftChild; // 左子树
    public BinaryNode rightChild; // 右子树

    public BinaryNode(Object data, BinaryNode leftChild, BinaryNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BinaryNode(Object data) {
        this(data, null, null);
    }

    @Override
    public String toString() {
        Object left = leftChild != null ? leftChild.data : null;
        Object right = rightChild != null ? rightChild.data : null;
        return "BinaryNode{" +
                "data=" + data +
                ", leftChild=" + left +
                ", rightChild=" + right +
                '}';
    }
}
