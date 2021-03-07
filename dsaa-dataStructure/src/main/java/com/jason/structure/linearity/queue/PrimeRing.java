package com.jason.structure.linearity.queue;

/**
 * 素数环问题
 * <br/>
 * 素数也称为质数，其定义为：在大于1的自然数中，除了1和它本身不再有其它因数的自然数（如：2、3、5、7、11、13、17等），与质数相对应的是合数。
 * <pre>
 *     素数环是指将从1到n这n个整数围成一个圆环，若其中任意2个相邻的数字相加，结果均为素数，那么这个环就成为素数环。
 *     首先素数环的个数必须是偶数。
 *     比如：
 *                                  1
 *                                /   \
 *                             2        2
 *                           /           \
 *                          5              3
 *                            \          /
 *                             6       4
 *                              \    /
 *                                7
 * </pre>
 *
 * @author WangChenHol
 * @date 2021/3/5 15:51
 **/
public class PrimeRing {

    /**
     * 打印素数环
     *
     * @param num 素数环的个数
     * @return 符合数量的素数环
     */
    public static String printPrimeRing(int num) throws Exception {

        if (num % 2 != 0) {
            throw new Exception("素数环不存在");
        }

        return null;
    }

}
