package com.jason.structure.linearity.linear;

/**
 * 线性表的顺序存储实现类。
 *
 * @author WangChenHol
 * @date 2021/1/20 15:43
 **/
public class OrderList implements LinearList {

    private final Object[] elements; // 线性表的存储空间，使用数组来实现
    private int currentLength; //线性表的当前长度

    public OrderList(int maxSize) {
        currentLength = 0;
        elements = new Object[maxSize];
    }

    @Override
    public void clear() {
        currentLength = 0;
    }

    @Override
    public boolean isEmpty() {
        return currentLength == 0;
    }

    @Override
    public int length() {
        return currentLength;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i > currentLength - 1) {
            throw new IndexOutOfBoundsException("第" + i + "个元素不存在");
        }
        return elements[i];
    }

    @Override
    public void insert(int i, Object e) {
        if (currentLength == elements.length) {
            throw new ArrayIndexOutOfBoundsException("顺序表已满");
        }
        if (i < 0 || i > currentLength) {
            throw new IndexOutOfBoundsException("第" + i + "个元素不存在");
        }
        // 把当前位置后面的元素全部往后移一位
        System.arraycopy(elements, i, elements, i + 1, currentLength - i);
        elements[i] = e;
        currentLength++;
    }

    @Override
    public void add(Object object) {
        if (currentLength == elements.length) {
            throw new ArrayIndexOutOfBoundsException("顺序表已满");
        }
        elements[currentLength] = object;
        currentLength++;
    }

    @Override
    public Object remove(int i) {
        if (i < 0 || i >= currentLength) {
            throw new IndexOutOfBoundsException("删除的位置超出范围");
        }
        Object removeEle = elements[i];
        for (int j = i; j < currentLength - 1; j++) {
            elements[j] = elements[j + 1];
        }
        elements[--currentLength] = null;
        return removeEle;
    }

    @Override
    public int indexOf(Object e) {
        if (e == null) {
            for (int i = 0; i < currentLength; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int j = 0; j < currentLength; j++) {
                if (e.equals(elements[j])) {
                    return j;
                }
            }
        }
        return -1;
    }

    @Override
    public void display() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (Object o : elements) {
            builder.append(o).append(" ");
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
}
