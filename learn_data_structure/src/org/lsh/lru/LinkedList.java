package org.lsh.lru;

/**
 *  单向链表实现LRU缓存淘汰机制
 */
public class LinkedList<T> {
    int size;
    Node list;

    public LinkedList() {
        size=0;
    }

    //添加节点
    /**
     * 在头部添加节点
     * @param data
     */
    public void put(T data){
        Node head= list;
        Node currentNode= new Node(data,head);
        list =currentNode;
        size++;
    }

    /**
     * 在index的位置添加节点
     * @param index
     * @param data
     */
    public void put(int index, T data){
        checkPositionIndex(index);
        Node head=list;
        Node currentNode=list;
        for (int i=0;i<index;i++){
            head=currentNode;
            currentNode=currentNode.next;
        }
        Node node=new Node(data,currentNode);
        head.next=node;
        size++;
    }

    //修改节点

    /**
     * 修改index位置上的数据
     * @param index
     * @param data
     */
    public void set(int index,T data){
        checkPositionIndex(index);
        Node head=list;
        for (int i = 0; i < index; i++) {
            head =head.next;
        }
        head.data=data;
    }
    //删除节点
    /**
     * 删除头节点
     * @return
     */
    public T remove(){
        if(list != null){
            Node node=list;
            list =list.next;
            node.next=null;
            size--;
            return node.data;
        }
        return  null;
    }

    /**
     * 删除index位置上的节点
     * @param index
     * @return
     */
    public T remove(int index){
        checkPositionIndex(index);
        Node head=list;
        Node currentNode=list;
        for (int i = 0; i < index; i++) {
            head=currentNode;
            currentNode=currentNode.next;
        }
        head.next=currentNode.next;
        currentNode.next=null;
        size--;
        return currentNode.data;
    }

    /**
     *  删除最后的节点
     * @return
     */
    public T removeLast(){
        if(list != null){
            Node node =list;
            Node currentNode=list;
            while(currentNode.next !=null){
                node = currentNode;
                currentNode = currentNode.next;
            }
            node.next =null;
            size--;
            return currentNode.data;
        }
        return null;
    }
    //查询节点

    /**
     * 获取头节点
     * @return
     */
    public T get(){
        if(list !=null){
            return list.data;
        }
        return null;
    }

    /**
     * 获取index位置的节点
     * @param index
     * @return
     */
    public T get(int index){
        checkPositionIndex(index);
        Node node=list;
        for (int i = 0; i < index; i++) {
            node =node.next;
        }
        return node.data;
    }
    /**
     * 检查是否越界
     * @param index
     */
    public void checkPositionIndex(int index) {
        if(!(index>=0 &&index<=size)){
            throw new IndexOutOfBoundsException("index "+index +",size:"+size);
        }
    }

    @Override
    public String toString() {
        Node node=list;
        for (int i = 0; i < size; i++) {
            System.out.print(node.data+" ");
            node =node.next;
        }
        System.out.println(" ");
        return super.toString();
    }

    /**
     * 链表节点信息
     */
    class Node{
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.put(i);
        }
        linkedList.toString();
//        linkedList.put(21,21);
        linkedList.put(10,10);
        linkedList.toString();
        linkedList.put(11,11);
        linkedList.toString();
        linkedList.set(2,20);
        linkedList.toString();
        linkedList.remove();
        linkedList.toString();
        linkedList.remove(3);
        linkedList.toString();
        linkedList.removeLast();
        linkedList.toString();
    }
}
