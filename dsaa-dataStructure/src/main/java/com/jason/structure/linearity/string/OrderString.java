package com.jason.structure.linearity.string;

/**
 * 顺序串的实现
 *
 * @author WangChenHol
 * @date 2021/3/9 17:48
 **/
public class OrderString implements IString {
    private char[] value; // 因为本类中存在insert方法，故此变量不能设置成final修饰
    private int length;

    /**
     * 构造方法1，初始化一个空串
     */
    public OrderString() {
        this.value = new char[0];
        this.length = 0;
    }

    /**
     * 构造方法2，初始化一个串，其内容为str的内容，长度等于str的长度
     *
     * @param str String
     */
    public OrderString(String str) {
        char[] toCharArray = str.toCharArray();
        this.value = toCharArray;
        this.length = toCharArray.length;
    }

    /**
     * 构造方法3，初始化一个串，其内容为char类型的数组。
     *
     * @param value char []
     */
    public OrderString(char[] value) {
        this.value = value;
        this.length = value.length;
    }

    @Override
    public void clear() {
        length = 0;
        value = new char[0];
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public char charAt(int index) {
        assertStr(index < 0 || index >= length, index);

        return value[index];
    }

    @Override
    public IString substring(int begin, int end) {
        assertStr(begin < 0, begin);
        assertStr(end > length, end);
        int subLen = end - begin;
        assertStr(subLen < 0, subLen);
        if (begin == 0 && end == length) {
            return this;
        }
        char[] chars = new char[subLen];
        System.arraycopy(value, begin, chars, 0, subLen);
        return new OrderString(chars);
    }

    @Override
    public IString insert(int offset, IString str) {
        if (str == null) {
            throw new NullPointerException("插入对象不能为空null");
        }
        assertStr(offset < 0 || offset > length, offset);
        char[] chars = new char[length + str.length()];

        if (isEmpty()) {
            this.length = str.length();
            this.value = str.toCharArray();
            return this;
        }
        int copyLen = offset;
        System.arraycopy(value, 0, chars, 0, copyLen);

        int idx = copyLen + str.length();
        for (int i = copyLen; i < idx; i++) {
            chars[i] = str.charAt(i - copyLen);
        }
        copyLen = length - offset;
        System.arraycopy(value, offset, chars, idx, copyLen);

        this.value = chars;
        this.length = chars.length;
        return this;
    }

    @Override
    public IString delete(int begin, int end) {
        assertStr(begin < 0, begin);
        assertStr(end > length, end);
        int subLen = end - begin;
        assertStr(subLen < 0, subLen);

        char[] chars = new char[length - subLen];
        System.arraycopy(value, 0, chars, 0, begin);
        System.arraycopy(value, end, chars, begin, length - end);

        char[] delChar = new char[subLen];
        System.arraycopy(value, begin, delChar, 0, subLen);

        this.value = chars;
        this.length = chars.length;
        return new OrderString(delChar);
    }

    @Override
    public IString concat(IString str) {
        return insert(length, str);
    }

    @Override
    public int compareTo(IString str) {
        int len1 = length;
        int len2 = str.length();

        int min = Math.min(len1, len2);
        for (int i = 0; i < min; i++) {
            char c1 = value[i];
            char c2 = str.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return len1 - len2;
    }

    @Override
    public int indexOf(IString str, int begin) {
        // TODO 两种匹配算法
        // Brute-Force模式匹配算法
        return bruteForce(str, begin);
        // KMP模式匹配算法
    }

    private int bruteForce(IString str, int begin) {
        if (str == null || length == 0 || str.length() == 0) {
            throw new NullPointerException("串不能为空");
        }
        int tLen = str.length(); // 被比较的串的长度
        if (tLen > length) {
            return -1;
        }

        int rLen = length - begin; //从当前被比较的位置开始算主串中剩余长度
        int i = begin, j = 0;
        while (rLen >= tLen) {
            char c1 = charAt(i);
            char c2 = str.charAt(j);
            if (c1 == c2) {
                if (j == tLen - 1) {
                    return i - j;
                }
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
                rLen--;
            }
        }
        return -1;
    }

    @Override
    public char[] toCharArray() {
        return value;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(value[i]);
        }
        return builder.toString();
    }

    private void assertStr(boolean exp, int index) {
        if (exp) {
            throw new StringIndexOutOfBoundsException("位置不合法：" + index);
        }
    }
}
