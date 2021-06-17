package com.jason.structure.nonlinearity.tree;

import com.jason.structure.nodes.BinaryNode;

/**
 * 树的接口
 *
 * @author WangChenHol
 * @date 2021/6/10 16:12
 **/
public interface Tree {

    /**
     * 先根遍历递归算法
     *
     * @param treeNode 二叉树结点
     * @return 遍历结果
     */
    String firstRootTraversal(BinaryNode treeNode);

    /**
     * 先根遍历非递归算法
     *
     * @return 遍历结果
     */
    String firstRootTraversal() throws Exception;

    /**
     * 中根遍历递归算法
     *
     * @param treeNode 二叉树结点
     * @return 遍历结果
     */
    String inRootTraversal(BinaryNode treeNode);

    /**
     * 中根遍历非递归算法
     *
     * @return 遍历结果
     */
    String inRootTraversal();

    /**
     * 后根遍历递归算法
     *
     * @param treeNode 二叉树结点
     * @return 遍历结果
     */
    String afterRootTraversal(BinaryNode treeNode);

    /**
     * 后根遍历非递归算法
     *
     * @return 遍历结果
     */
    String afterRootTraversal();


    /**
     * 层次遍历非递归算法
     *
     * @return 遍历结果
     */
    String levelTraversal() throws Exception;
}

