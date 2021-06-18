package com.jason.structure.nonlinearity.tree;

import com.jason.structure.nodes.HuffmanNode;

import java.util.Arrays;

/**
 * 哈夫曼树（也就是最优二叉树）。
 * 其特点是：树的带权路径长度最小。
 *
 * @author WangChenHol
 * @date 2021/6/17 16:12
 **/
public class HuffmanTree {

    /**
     * 求哈夫曼编码的算法
     *
     * @param weights 各个结点的权值数组
     * @return 哈夫曼编码
     */
    public static int[][] huffmanCoding(int[] weights) {
        int n = weights.length; // 字符个数
        int m = 2 * n - 1; // 哈夫曼树的结点数量
        HuffmanNode[] huffman = new HuffmanNode[m];
        int i;
        for (i = 0; i < n; i++) {
            huffman[i] = new HuffmanNode(weights[i]); // 首先构造n个具有权值的结点
        }
        for (i = n; i < m; i++) {
            // 选择不在选择未加入到哈夫曼树中权值最小的两个结点。
            HuffmanNode min1 = selectMin(huffman, i - 1);
            min1.flag = 1;
            HuffmanNode min2 = selectMin(huffman, i - 1);
            min2.flag = 1;

            // 构造最小两个结点的父结点，并修改父结点的权值
            HuffmanNode parent = new HuffmanNode();
            min1.parent = parent;
            min2.parent = parent;
            parent.leftChild = min1;
            parent.rightChild = min2;
            parent.weight = min1.weight + min2.weight;
            huffman[i] = parent;
        }
        // 从叶子结点到根结点求每个字符的哈夫曼编码
        int[][] huffmanCode = new int[n][n];
        for (int j = 0; j < n; j++) {
            int start = n - 1;
            for (HuffmanNode c = huffman[j], p = c.parent; p != null; c = p, p = p.parent) {
                if (p.leftChild.equals(c)) {
                    huffmanCode[j][start--] = 0;
                } else {
                    huffmanCode[j][start--] = 1;
                }
            }
            huffmanCode[j][start] = -1;
        }
        return huffmanCode;
    }

    /**
     * 选择权值最小的结点
     *
     * @param nodes 结点数组
     * @param end   选择范围
     * @return 最小结点
     */
    private static HuffmanNode selectMin(HuffmanNode[] nodes, int end) {
        HuffmanNode min = nodes[end];
        for (int i = 0; i <= end; i++) {
            HuffmanNode huffmanNode = nodes[i];
            if (huffmanNode.flag == 0 && huffmanNode.weight < min.weight) {
                min = huffmanNode;
            }
        }
        return min;
    }

    public static void display(int[][] huffman) {
        for (int i = 0; i < huffman.length; i++) {
            System.out.print(Arrays.toString(huffman[i]) + " ");
            for (int j = 0; j < huffman[i].length; j++) {
                if (huffman[i][j] == -1) {
                    for (int k = j + 1; k < huffman[i].length; k++) {
                        System.out.print(huffman[i][k]);
                    }
                    break;
                }
            }
            System.out.println("");
        }
    }
}
