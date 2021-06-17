package com.jason.structure.linearity.nonlinearity;

import com.jason.structure.nonlinearity.tree.BinaryTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

/**
 * @author WangChenHol
 * @date 2021/6/11 10:19
 **/
public class TestTree {
    @Test
    public void testBinaryTree() throws Exception {
        BinaryTree tree = new BinaryTree("ABDEGCFH", "DBGEAFHC", 0, 0, 8);
        System.out.println("先根遍历递归：" + tree.firstRootTraversal(tree.getRoot()) + "   先根遍历非递归：" + tree.firstRootTraversal());
        System.out.println("中根遍历递归：" + tree.inRootTraversal(tree.getRoot()) + "   中根遍历非递归：" + tree.inRootTraversal());
        System.out.println("后根遍历递归：" + tree.afterRootTraversal(tree.getRoot()) + "   后根遍历非递归：" + tree.afterRootTraversal());
        System.out.println("层次遍历：" + tree.levelTraversal());
        System.out.println("查找结点：" + tree.getNode("G"));
        System.out.println("查找结点：" + tree.getNode(tree.getNode("C"), "F"));
        System.out.println("结点总数：" + tree.count());
        System.out.println("深度：" + tree.depth());

        BinaryTree binaryTree = new BinaryTree("ABDEGCFH", "DBGEAFHC");
        System.out.println(binaryTree.firstRootTraversal(binaryTree.getRoot()));

        BinaryTree emptyTree1 = new BinaryTree("AB#D##C##");
        System.out.println(emptyTree1.firstRootTraversal(emptyTree1.getRoot()));
//        BinaryTree emptyTree2 = new BinaryTree("AB###");
//        System.out.println(emptyTree2.firstRootTraversal(emptyTree2.getRoot()));

        BinaryTree abcdefgh = new BinaryTree("ABCDEFGH", 0);
        System.out.println("先根遍历递归：" + abcdefgh.firstRootTraversal(abcdefgh.getRoot()));
        System.out.println("中根遍历递归：" + abcdefgh.inRootTraversal(abcdefgh.getRoot()));
        System.out.println("后根遍历递归：" + abcdefgh.afterRootTraversal(abcdefgh.getRoot()));
        System.out.println("层次遍历：" + abcdefgh.levelTraversal());
        System.out.println("结点总数：" + abcdefgh.count(abcdefgh.getRoot()));
        System.out.println("深度：" + abcdefgh.depth());

        System.out.println(abcdefgh.isEquals(new BinaryTree("ABDHECFG","DHBEAFCG")));
        System.out.println(abcdefgh.isEquals(new BinaryTree("ABDHECFG","HDBEAFCG")));
        System.out.println(new BinaryTree("ABCDEFG",0).isEquals(new BinaryTree("ABDECFG","DBEAFCG")));
        System.out.println(new BinaryTree("ABCDEFG",0).isEquals(new BinaryTree("ABDECGF","DBEAGCF")));

    }
}
