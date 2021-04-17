package com.jason.structure.linearity.queue;

import com.jason.structure.linearity.linear.OrderList;

import java.util.Objects;

/**
 * 素数环问题
 * <br/>
 * 素数也称为质数，其定义为：在大于1的自然数中，除了1和它本身不再有其它因数的自然数（如：2、3、5、7、11、13、17等），与质数相对应的是合数。
 * <pre>
 *     素数环是指将从1到n这n个整数围成一个圆环，若其中任意2个相邻的数字相加，结果均为素数，那么这个环就成为素数环。
 *     首先素数环的个数必须是偶数，并且每个整数只出现一次
 *     比如：
 *                                  1
 *                                /   \
 *                             12       2
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

        OrderList list = new OrderList(num);
        list.insert(0, 1);
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        for (int i = 2; i <= num; i++) {
            queue.offer(i);
        }
        return Objects.requireNonNull(insertRing(list, queue, 2, num)).display();
    }

    private static OrderList insertRing(OrderList list, LinkedQueue<Integer> queue, int index, int num) throws Exception {
        int count = 0;
        while (!queue.isEmpty() && count <= num - index) {
            int p = queue.poll();
            int q = (Integer) list.get(list.length() - 1);
            if (index == num) {
                if (isPrime(p + q) && isPrime(p + 1)) {
                    list.insert(list.length(), p);
                    return list;
                } else {
                    queue.offer(p);
                }
            } else if (isPrime(p + q)) {
                list.insert(list.length(), p);
                if (insertRing(list, queue, index + 1, num) != null) {
                    return list;
                }
                list.remove(list.length() - 1);
                queue.offer(p);
            } else {
                queue.offer(p);
            }
            ++count;
        }
        return null;
    }

    /**
     * 判断一个数是不是素数（质数）
     *
     * @param p 目标整数
     * @return true：是素数
     */
    private static boolean isPrime(int p) {
        if (p <= 1) {
            return false;
        }
        int p2 = p / 2 + 1;
        for (int i = 2; i < p2; i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(isPrime(12));
        System.out.println(isPrime(13));
        System.out.println(isPrime(14));
        System.out.println(isPrime(15));
        System.out.println(isPrime(16));
        System.out.println(isPrime(17));

        System.out.println(printPrimeRing(10));
    }

}
