package com.jason.structure.linearity.linear;

import com.jason.structure.linearity.array.DiagonalMatrix;
import com.jason.structure.linearity.array.IArray;
import com.jason.structure.linearity.array.SymmetricMatrix;
import com.jason.structure.linearity.array.TriangularMatrix;
import org.junit.Test;

/**
 * @author WangChenHol
 * @date 2021/6/4 15:49
 **/
public class TestArray {

    /**
     * 对称矩阵
     */
    @Test
    public void testSymmetricMatrix() throws Exception {
        SymmetricMatrix matrix = new SymmetricMatrix(6);
        matrix.assign("A", 0, 0);
        matrix.assign("B", 1, 0);
        matrix.assign("C", 1, 1);
        matrix.assign("D", 2, 0);
        matrix.assign("E", 2, 1);
        matrix.assign("F", 2, 2);
        matrix.assign("G", 3, 0);
        matrix.assign("H", 3, 1);
        matrix.assign("I", 3, 2);
        matrix.assign("J", 3, 3);
        matrix.assign("K", 4, 0);
        matrix.assign("L", 4, 1);
        matrix.assign("M", 4, 2);
        matrix.assign("N", 4, 3);
        matrix.assign("O", 4, 4);
        matrix.assign("P", 5, 0);
        matrix.assign("Q", 5, 1);
        matrix.assign("R", 5, 2);
        matrix.assign("S", 5, 3);
        matrix.assign("T", 5, 4);
        matrix.assign("U", 5, 5);

        System.out.println(matrix.toString());
        System.out.println(matrix.displayValues());
        System.out.println(matrix.getValue(3, 2));
        System.out.println(matrix.getValue(1, 4));
    }

    /**
     * 下三角矩阵
     */
    @Test
    public void testLowerTriangularMatrix() throws Exception {
        IArray matrix = new TriangularMatrix(5);

        matrix.assign("A", 0, 0);
        matrix.assign("B", 1, 0);
        matrix.assign("C", 1, 1);
        matrix.assign("D", 2, 0);
        matrix.assign("E", 2, 1);
        matrix.assign("F", 2, 2);
        matrix.assign("G", 3, 0);
        matrix.assign("H", 3, 1);
        matrix.assign("I", 3, 2);
        matrix.assign("J", 3, 3);
        matrix.assign("K", 4, 0);
        matrix.assign("L", 4, 1);
        matrix.assign("M", 4, 2);
        matrix.assign("N", 4, 3);
        matrix.assign("P", 4, 4);
        System.out.println(matrix.toString());
        System.out.println(matrix.displayValues());
        System.out.println("总数：" + matrix.getEleCount() + "  第2,1元素为:" + matrix.getValue(2, 1) + "  第2，4元素为:" + matrix.getValue(2, 4));
    }

    /**
     * 上三角矩阵
     */
    @Test
    public void testUpperTriangularMatrix() throws Exception {
        IArray matrix = new TriangularMatrix(5, false);

        matrix.assign("A", 0, 0);
        matrix.assign("B", 0, 1);
        matrix.assign("C", 1, 1);
        matrix.assign("D", 0, 2);
        matrix.assign("E", 1, 2);
        matrix.assign("F", 2, 2);
        matrix.assign("G", 0, 3);
        matrix.assign("H", 1, 3);
        matrix.assign("I", 2, 3);
        matrix.assign("J", 3, 3);
        matrix.assign("K", 0, 4);
        matrix.assign("L", 1, 4);
        matrix.assign("M", 2, 4);
        matrix.assign("N", 3, 4);
        matrix.assign("P", 4, 4);
        System.out.println(matrix.toString());
        System.out.println(matrix.displayValues());
        System.out.println("总数：" + matrix.getEleCount() + "  第2,1元素为:" + matrix.getValue(2, 1) + "  第2，4元素为:" + matrix.getValue(2, 4));
    }
    @Test
    public void testDiagonalMatrix() throws Exception {
        DiagonalMatrix matrix = new DiagonalMatrix(6, 2);
        matrix.assign("A", 0, 0);
        matrix.assign("B", 0, 1);
        matrix.assign("C", 1, 0);
        matrix.assign("D", 1, 1);
        matrix.assign("E", 1, 2);
        matrix.assign("F", 2, 1);
        matrix.assign("G", 2, 2);
        matrix.assign("H", 2, 3);
        matrix.assign("I", 3, 2);
        matrix.assign("J", 3, 3);
        matrix.assign("K", 3, 4);
        matrix.assign("L", 4, 3);
        matrix.assign("M", 4, 4);

        System.out.println(matrix.toString());
        System.out.println(matrix.displayValues());
    }
}
