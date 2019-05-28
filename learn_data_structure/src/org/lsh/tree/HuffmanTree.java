package org.lsh.tree;

import java.util.ArrayList;
import java.util.List;

public class HuffmanTree {
    //结点
    public static class Node<E>{
        E data;
        int weight;
        Node leftChild;
        Node rightChild;

        public Node(E data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node[weight="+weight+",data="+data+"]";
        }
    }

    public static void main(String[] args) {
        List<Node> nodeList=new ArrayList<>();
        nodeList.add(new Node("a",10));
        nodeList.add(new Node("b",15));
        nodeList.add(new Node("c",12));
        nodeList.add(new Node("d",3));
        nodeList.add(new Node("e",4));
        nodeList.add(new Node("f",13));
        nodeList.add(new Node("g",1));
        Node root=HuffmanTree.createTree(nodeList);
        printTree(root);
    }
    //递归打印
    private static void printTree(Node root) {
        System.out.println(root.toString());
        if(root.leftChild!=null){
            System.out.print("left:");
            printTree(root.leftChild);
        }
        if(root.rightChild!=null){
            System.out.print("right");
            printTree(root.rightChild);
        }
    }

    /**
     * 构造huffmanTree
     * @param nodeList
     * @return
     */
    private static Node createTree(List<Node> nodeList) {
        while (nodeList.size()>1){
            //什么是最小的，list表进行排序、增序的方式，0，1
            sort(nodeList);
            Node left=nodeList.get(0);//权重最小的
            Node right=nodeList.get(1);//权重第二小的
            //生成一个父节点，权重为两个子节点之和
            Node parent= new Node(null,left.weight+right.weight);
            //树的链接
            parent.leftChild=left;
            parent.rightChild=right;
            nodeList.remove(0);
            nodeList.remove(0);
            nodeList.add(parent);

        }
        return nodeList.get(0);
    }

    //冒泡排序
    private static void sort(List<Node> nodeList) {
        if (nodeList.size()<=1){
            return;
        }
        //循环数组长度次数
        for (int i = 0; i <nodeList.size(); i++) {
            /**
             * 从第0个元素开始，依次和后面的元素进行比较
             * j< array.length-1-i表示第[array.length-1-i]个元素已经冒泡到了合适的位置，
             * 无需进行比较，可以减少比较次数
             */

            for (int j = 0; j < nodeList.size()-1-i; j++) {
                /**
                 * 如果第j个元素比后面第j+1结点权重大，交换两者的位置
                 */
                if (nodeList.get(j+1).weight<nodeList.get(j).weight){
                    Node tmp=nodeList.get(j+i);
                    nodeList.set(j+1,nodeList.get(j));
                    nodeList.set(j,tmp);
                }
            }
        }
    }

}
