package org.lsh.queue;

/**
 * 循环队列
 * 数组实现
 */
public class ArrayCircularQueue {
    int size;
    static  final int DEFAULT_CAPACITY=10;

    Object[] data;

    public ArrayCircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayCircularQueue(int size) {
        this.size = size;
    }
    //插入
    //取出
}
