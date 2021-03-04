package com.jason.structure.linearity.stacks;

/**
 * 求两个大数的相加。
 * 比如：675384563783568367264378 + 2757834647826718716784378836
 *
 * @author ChenHol.Wong
 * @create 2021/3/2 21:49
 */
public class BigNumberSum {

    private final LinkedStack sum = new LinkedStack();// 求和后的结果


    public String add(String a, String b) throws Exception {

        boolean isGo = false; // 是否进一位
        // 加数
        LinkedStack add = splitNumber(a);
        // 被加数
        LinkedStack sadd = splitNumber(b);
        if (add == null) {
            return result(sadd);
        }
        if (sadd == null) {
            return result(add);
        }

        while (!add.isEmpty() && !sadd.isEmpty()) {
            Integer f = Integer.valueOf(add.pop().toString());
            Integer d = Integer.valueOf(sadd.pop().toString());
            int s = f + d;
            isGo = pushNumber(isGo, s);
        }

        while (!add.isEmpty()) {
            int valueOf = Integer.parseInt(add.pop().toString());
            isGo = pushNumber(isGo, valueOf);

        }
        while (!sadd.isEmpty()) {
            int valueOf = Integer.parseInt(sadd.pop().toString());
            isGo = pushNumber(isGo, valueOf);
        }
        if (isGo) {
            sum.push(1);
        }
        return result(sum);
    }

    private boolean pushNumber(boolean isGo, int s) throws Exception {
        int units;// 相加后的个位数
        if (isGo) {
            units = s + 1; // 需要进一位
        } else {
            units = s; // 不需要进位
        }
        if (units > 9) {
            isGo = true;
            units = units - 10; // 如果相加后大于10，则保留个位数入栈
        } else {
            isGo = false;
        }
        sum.push(units);
        return isGo;
    }

    /**
     * 分隔大数的字符串
     *
     * @param number 大数
     */
    private LinkedStack splitNumber(String number) throws Exception {
        if (number == null || "".equals(number.trim())) {
            return null;
        }
        LinkedStack stack = new LinkedStack();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i); // 取每一位的数字
            if (' ' == c) {
                continue;
            }
            if (c >= '0' && c <= '9') {
                stack.push(c);
            } else {
                throw new Exception("输出的数字不合法[" + c + "]");
            }
        }
        return stack;
    }

    private String result(LinkedStack stack) {
        if (stack == null || stack.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
