package com.jason.structure.nonlinearity.tree;


import com.jason.structure.linearity.queue.LinkedQueue;
import com.jason.structure.linearity.stacks.LinkedStack;
import com.jason.structure.nodes.BinaryNode;

/**
 * 普通二叉树的操作。
 * <pre>
 *     三种创建二叉树的方式：
 *          1.根据先根遍历序列和中根遍历序列创建。
 *          2.根据标明空子树（由#替代）的先根遍历序列创建。
 *          3.由完全二叉树的顺序存储结构建立其二叉链表式存储结构。
 * </pre>
 * 二叉树中的非递归遍历操作实现采用间接转换法，引入一个栈来保存中间结果。<p/>
 *
 * @author WangChenHol
 * @date 2021/6/10 16:24
 **/
public class BinaryTree implements Tree {

    private BinaryNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(BinaryNode root) {
        this.root = root;
    }

    /**
     * 根据 先根序列 和 中根序列 创建一个二叉树
     *
     * @param firstOrder 先根序列
     * @param inOrder    中根序列
     * @param firstIndex 在先根遍历序列中的开始位置
     * @param inIndex    在中根遍历序列的开始位置
     * @param count      二叉树的结点个数
     */
    public BinaryTree(String firstOrder, String inOrder, int firstIndex, int inIndex, int count) {
        if (count > 0) {
            char r = firstOrder.charAt(firstIndex); // 找出先根遍历的根结点
            int i = 0;
            for (; i < count; i++) { // 找到根结点在中根遍历中的位置
                if (r == inOrder.charAt(i + inIndex)) {
                    break;
                }
            }
            root = new BinaryNode(r); // 建立根结点
            root.leftChild = new BinaryTree(firstOrder, inOrder, firstIndex + 1, inIndex, i).root; // 建立左子树
            root.rightChild = new BinaryTree(firstOrder, inOrder, firstIndex + 1 + i, inIndex + 1 + i, count - i - 1).root; // 建立右子树
        }
    }

    /**
     * 根据 先根序列 和 中根序列 创建一个二叉树
     *
     * @param firstOrder 先根序列
     * @param inOrder    中根序列
     */
    public BinaryTree(String firstOrder, String inOrder) {
        if (firstOrder == null || firstOrder.equals("")) {
            return;
        }
        char r = firstOrder.charAt(0);
        root = new BinaryNode(r);

        int rootIndexInInOrder = 0; // 根结点在中根遍历中的位置
        for (; rootIndexInInOrder < firstOrder.length(); rootIndexInInOrder++) {
            if (r == inOrder.charAt(rootIndexInInOrder)) {
                break;
            }
        }
        root.leftChild = new BinaryTree(firstOrder.substring(1, rootIndexInInOrder + 1), inOrder.substring(0, rootIndexInInOrder)).root; // 左子树
        root.rightChild = new BinaryTree(firstOrder.substring(rootIndexInInOrder + 1), inOrder.substring(rootIndexInInOrder + 1)).root; // 右子树
    }


    private static int rootIndex = 0;

    /**
     * 由标明空子树的先根遍历序列创建一棵二叉树
     *
     * @param firstOrder 标明空子树的先根序列
     */
    public BinaryTree(String firstOrder) {
        if (firstOrder == null || firstOrder.equals("")) {
            return;
        }
        char c = firstOrder.charAt(rootIndex++);
        if (c == '#') {
            root = null;
        } else {
            root = new BinaryNode(c);
            root.leftChild = new BinaryTree(firstOrder).root;
            root.rightChild = new BinaryTree(firstOrder).root;
        }
    }

    /**
     * 由完全二叉树的顺序存储结构建立其二叉链表式存储结构
     *
     * @param complateBinaryTree 完全二叉树的顺序存储结构
     * @param rootIndex          根结点在序列中的位置
     */
    public BinaryTree(String complateBinaryTree, int rootIndex) {
        if (rootIndex < complateBinaryTree.length()) {
            root = new BinaryNode(complateBinaryTree.charAt(rootIndex));
            root.leftChild = new BinaryTree(complateBinaryTree, 2 * rootIndex + 1).root;
            root.rightChild = new BinaryTree(complateBinaryTree, 2 * rootIndex + 2).root;
        }
    }

    @Override
    public String firstRootTraversal(BinaryNode treeNode) {
        String value = "";
        if (treeNode != null) {
            value = String.valueOf(treeNode.data);
            value += firstRootTraversal(treeNode.leftChild);
            value += firstRootTraversal(treeNode.rightChild);
        }
        return value;
    }

    @Override
    public String firstRootTraversal() {
        BinaryNode node = root;
        StringBuilder value = new StringBuilder();
        if (node != null) {
            LinkedStack stack = new LinkedStack();
            stack.push(node);
            while (!stack.isEmpty()) {
                node = (BinaryNode) stack.pop();
                value.append(node.data);
                while (node != null) {
                    if (node.leftChild != null) {
                        value.append(node.leftChild.data);
                    }
                    if (node.rightChild != null) {
                        stack.push(node.rightChild);
                    }
                    node = node.leftChild;
                }
            }
        }
        return value.toString();
    }

    @Override
    public String inRootTraversal(BinaryNode treeNode) {
        String value = "";
        if (treeNode != null) {
            value += inRootTraversal(treeNode.leftChild);
            value += String.valueOf(treeNode.data);
            value += inRootTraversal(treeNode.rightChild);
        }
        return value;
    }

    @Override
    public String inRootTraversal() {
        BinaryNode node = root;
        StringBuilder value = new StringBuilder();
        if (node != null) {
            LinkedStack stack = new LinkedStack();
            stack.push(root);
            while (!stack.isEmpty()) {
                while (stack.peek() != null) {
                    stack.push(((BinaryNode) stack.peek()).leftChild); // 将栈顶元素的左子结点依次全部入栈（此时最后一个元素是空）。
                }
                stack.pop(); // 最后的空元素出栈
                if (!stack.isEmpty()) {
                    node = (BinaryNode) stack.pop(); // 读取栈顶元素
                    value.append(node.data);
                    stack.push(node.rightChild); // 将栈顶元素结点的右子结点入栈
                }
            }
        }
        return value.toString();
    }

    @Override
    public String afterRootTraversal(BinaryNode treeNode) {
        String value = "";
        if (treeNode != null) {
            value += afterRootTraversal(treeNode.leftChild);
            value += afterRootTraversal(treeNode.rightChild);
            value += String.valueOf(treeNode.data);
        }
        return value;
    }

    @Override
    public String afterRootTraversal() {
        StringBuilder value = new StringBuilder();
        BinaryNode node = root;
        if (node != null) {
            LinkedStack stack = new LinkedStack();
            stack.push(node);
            boolean visitFlag;
            BinaryNode p = null;
            while (!stack.isEmpty()) {
                while (stack.peek() != null) {
                    stack.push(((BinaryNode) stack.peek()).leftChild);
                }
                stack.pop();
                while (!stack.isEmpty()) {
                    node = (BinaryNode) stack.peek();
                    if (node.rightChild == null || node.rightChild == p) {
                        value.append(node.data);
                        stack.pop();
                        p = node;
                        visitFlag = true;
                    } else {
                        stack.push(node.rightChild);
                        visitFlag = false;
                    }
                    if (!visitFlag) {
                        break;
                    }
                }
            }
        }
        return value.toString();
    }

    @Override
    public String levelTraversal() throws Exception {
        StringBuilder value = new StringBuilder();
        BinaryNode node = root;
        if (node != null) {
            LinkedQueue<BinaryNode> queue = new LinkedQueue<>();
            queue.offer(node);
            while (!queue.isEmpty()) {
                node = queue.poll();
                value.append(node.data);
                if (node.leftChild != null) {
                    queue.offer(node.leftChild);
                }
                if (node.rightChild != null) {
                    queue.offer(node.rightChild);
                }
            }
        }
        return value.toString();
    }

    /**
     * 在当前二叉树中查找值为value的结点，并返回
     *
     * @param value 查找的值
     * @return 查找到的结点
     */
    public BinaryNode getNode(Object value) {
        return getNode(root, value);
    }

    /**
     * 在指定树中查找值为value的结点
     *
     * @param node  指定结点
     * @param value 查找值
     * @return 查找到的结点
     */
    public BinaryNode getNode(BinaryNode node, Object value) {
        if (node == null) {
            return null;
        }
        if (String.valueOf(value).equals(String.valueOf(node.data))) {
            return node;
        }
        BinaryNode leftNode = getNode(node.leftChild, value);
        return leftNode == null ? getNode(node.rightChild, value) : leftNode;
    }

    /**
     * @return 树中结点的总个数
     */
    public int count() {
        return count(root);
    }

    /**
     * @param node 指定的结点数
     * @return 树中结点的总个数
     */
    public int count(BinaryNode node) {
        int count = 0;
        if (node != null) {
            count++;
            count += count(node.leftChild);
            count += count(node.rightChild);
        }
        return count;
    }

    public int depth() {
        return depth(root);
    }

    public int depth(BinaryNode node) {
        if (node != null) {
            int leftDepth = depth(node.leftChild);
            int rightDepth = depth(node.rightChild);
            return 1 + (Math.max(leftDepth, rightDepth));
        }
        return 0;
    }

    /**
     * 比较当前树和被比较的树是否相同
     *
     * @param tree 被比较的树
     * @return true：相同
     */
    public boolean isEquals(BinaryTree tree) {
        return isEquals(root, tree.getRoot());
    }

    /**
     * 判断两个结点是否相同
     *
     * @param node1 结点1
     * @param node2 结点2
     * @return true：相同
     */
    public boolean isEquals(BinaryNode node1, BinaryNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (!node1.data.equals(node2.data)) {
            return false;
        }
        return isEquals(node1.leftChild, node2.leftChild) && isEquals(node1.rightChild, node2.rightChild);
    }

    public BinaryNode getRoot() {
        return root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

}
