package com.jason.structure.linearity.linear;

import com.jason.structure.linearity.array.SymmetricMatrix;
import org.junit.Test;

/**
 * @author WangChenHol
 * @date 2021/6/4 15:49
 **/
public class TestArray {

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
        System.out.println(matrix.values());
    }
}
