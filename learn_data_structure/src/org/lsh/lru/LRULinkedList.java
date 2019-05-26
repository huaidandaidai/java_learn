package org.lsh.lru;

public class LRULinkedList<T> extends LinkedList<T> {
    int memory_size;//用于限定内存空间的大小，也就是缓存大小
    static final int DEFAULT_CUP=5;

    public LRULinkedList() {
        this(DEFAULT_CUP);
    }

    public LRULinkedList(int memory_size) {
        this.memory_size = memory_size;
    }

    /**
     * 存放节点
     * 首先判断是否满了
     *  若未满，则头部存放节点
     * @param data
     */
    public void lruPut(T data){
        if(size>=memory_size){
            removeLast();
            put(data);
        }else{
            put(data);
        }
    }

    /**
     * 删除
     * @return
     */
    public T lruRemove(){
        return removeLast();
    }

    /**
     * 访问
     * @return
     */
    public T lruGet(int index){
        checkPositionIndex(index);
        Node node=list;
        Node currentNode=list;
        for (int i = 0; i < index; i++) {
            node=currentNode;
            currentNode= currentNode.next;
        }
        node.next=currentNode.next;
        Node head=list;
        currentNode.next=head;
        list=currentNode;
        return currentNode.data;
    }

    public static void main(String[] args) {
        LRULinkedList<Integer> lruLinkedList=new LRULinkedList<>(5);
        for (int i = 0; i < 10; i++) {
            lruLinkedList.lruPut(i);
            lruLinkedList.toString();
        }
    }
}
