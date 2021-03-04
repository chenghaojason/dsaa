package com.jason.structure.linearity.queue;

/**
 * 队列抽象接口
 *
 * @author WangChenHol
 * @date 2021/3/4 16:07
 **/
public interface IQueue<T> {
    /**
     * 清空
     */
    void clear();

    /**
     * 判断队列是否为空
     *
     * @return true为空
     */
    boolean isEmpty();

    /**
     * 判断队列是否已经满了
     *
     * @return true，队列满了
     */
    boolean isFull();

    /**
     * 返回队列中元素的个数
     *
     * @return 元素个数
     */
    int length();

    /**
     * 读取队首元素
     *
     * @return 队首元素值
     */
    T peek();

    /**
     * 入队，将新元素插入到队尾
     *
     * @param data 数据
     * @throws Exception 异常
     */
    void offer(T data) throws Exception;

    /**
     * 删除队首数据元素，如果队列为空则返回null
     *
     * @return 删除的数据
     */
    T poll();

}
