package org.lsh.lru;

/**
 *  单向链表实现LRU缓存淘汰机制
 */
public class LRU {

    /**
     *  链表数据结构
     * @param <E>
     */
    public static class Node<E>{
        E Data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            Data = data;
            this.next = next;
        }
    }
}
