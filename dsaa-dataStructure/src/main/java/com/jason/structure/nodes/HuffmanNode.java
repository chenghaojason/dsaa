package com.jason.structure.nodes;

/**
 * 哈夫曼树的结点
 *
 * @author WangChenHol
 * @date 2021/6/17 16:13
 **/
public class HuffmanNode {

    public int weight; // 结点的权值
    public int flag; // 结点是否已经加入到哈夫曼树的标志
    public HuffmanNode parent, leftChild, rightChild; // 父结点、左子结点、右子结点

    public HuffmanNode() {
        this(0);
    }

    public HuffmanNode(int weight) {
        this.weight = weight;
        flag = 0;
        parent = leftChild = rightChild = null;
    }
}
