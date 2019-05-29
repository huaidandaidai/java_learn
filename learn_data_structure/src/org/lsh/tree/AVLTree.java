package org.lsh.tree;

/**
 * 平衡二叉树
 */
public class AVLTree {
    public static class Node{
        int data;//数据
        Node leftChild;//左子节点
        Node rightChild;//右子节点
        int height;//节点高度

        public Node(int data) {
            this.data = data;
        }
    }
    //获取节点高度
    public static int getHeight(Node p){
        return p == null? -1:p.height;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root,30);
        root = insert(root,20);
        root = insert(root,40);
        root = insert(root,10);
        root = insert(root,25);
        //插入失衡节点
        root = insert(root,5);

        printTree(root);

    }

    /**
     * 打印tree
     * @param root
     */
    private static void printTree(Node root) {
        System.out.println(root.data);
        if (root.leftChild!=null){
            System.out.print("left:");
            printTree(root.leftChild);
        }
        if (root.rightChild!=null){
            System.out.print("right:");
            printTree(root.rightChild);
        }
    }

    private static Node insert(Node root, int data) {
        if (root == null){
            root = new Node(data);
            return  root;
        }
        if(data<=root.data){
            root.leftChild=insert(root.leftChild,data);
            //平衡调整
            if(getHeight(root.leftChild)-getHeight(root.rightChild)>1){
                if(data<=root.leftChild.data){
                    System.out.println("LL旋转");
                    root=LLRotate(root);
                }else{
                    System.out.println("LR旋转");
                    root= LRRotate(root);
                }
            }
        }else{
            root.rightChild=insert(root.rightChild,data);
            //平衡调整
            if(getHeight(root.rightChild)-getHeight(root.leftChild)>1){
                if(data<=root.rightChild.data){
                    System.out.println("RL旋转");
                    root=RLRotate(root);
                }else{
                    System.out.println("RR旋转");
                    root= RRRotate(root);
                }
            }
        }
        //重新调整root节点的高度
        root.height=Math.max(getHeight(root.leftChild),getHeight(root.rightChild))+1;
        return root;
    }

    private static Node RLRotate(Node root) {
        root.rightChild = LLRotate(root.rightChild);
        return RRRotate(root);
    }


    private static Node LRRotate(Node root) {
        root.leftChild = RRRotate(root.leftChild);
        return LLRotate(root);
    }

    private static Node LLRotate(Node root) {
        Node rsubTree =root.leftChild;
        root.leftChild = rsubTree.rightChild;
        rsubTree.rightChild= root;
        root.height=Math.max(getHeight(root.leftChild),getHeight(root.rightChild))+1;
        rsubTree.height=Math.max(getHeight(rsubTree.leftChild),getHeight(rsubTree.rightChild))+1;
        return rsubTree;
    }
    private static Node RRRotate(Node root) {
        Node rsubTree =root.rightChild;
        root.rightChild = rsubTree.leftChild;
        rsubTree.leftChild= root;
        root.height=Math.max(getHeight(root.leftChild),getHeight(root.rightChild))+1;
        rsubTree.height=Math.max(getHeight(rsubTree.leftChild),getHeight(rsubTree.rightChild))+1;
        return rsubTree;
    }

}
