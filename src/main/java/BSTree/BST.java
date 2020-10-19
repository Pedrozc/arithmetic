package BSTree;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**添加元素**/
//    // 向二分搜索树中添加新的元素e
//    public void add(E e){
//        if(root == null){
//            root = new Node(e);
//        }else {
//            add(root, e);
//        }
//    }
//
//    // 向以node为根的二分搜索树中插入元素e，递归算法
//    private void add(Node node, E e){
//        if(node.e.equals(e)){
//            return;
//        }else if(e.compareTo(node.e) < 0){
//            if(node.left == null) {
//                node.left = new Node(e);
//                size++;
//                return;
//            }else {
//                add(node.left, e);
//            }
//        }else if(e.compareTo(node.e) > 0){
//            if(node.right == null) {
//                node.right = new Node(e);
//                size++;
//                return;
//            }else {
//                add(node.right, e);
//            }
//        }
//    }
    // 向以node为根的二分搜索树中插入元素e，递归算法
    private Node add(Node node, E e){
        if(node == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }
    // 向二分搜索树中添加新的元素e
    public void add(E e){
        root = add(root, e);
    }

    /**查找**/
    // 看以node为根的二分搜索树中是否包含元素e, 递归算法
    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if(e.compareTo(e) == 0){
            return true;
        }else if(e.compareTo(e) > 0){
            return contains(node.right, e);
        }else{
            return contains(node.left, e);
        }
    }

    // 看二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root, e);
    }

    /***遍历***/
    // 前序遍历以node为根的二分搜索树, 递归算法

    private void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    // 中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }

    // 后序遍历以node为根的二分搜索树, 递归算法
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

    // 二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }


    // 二分搜索树的非递归前序遍历
    public void preOrderNR(){

        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    // 二分搜索树的层序遍历   用队列
    public void levelOrder(){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            Node cur =q.remove();
            System.out.println(cur.e);

            if(cur.left != null){
                q.add(cur.left);
            }
            if(cur.right != null){
                q.add(cur.right);
            }
        }
    }

    /**查找最大最小值***/

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    // 寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }


    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maxmum(Node node){
        if(node.right == null){
            return node;
        }
        return  maxmum(node.right);
    }

    // 寻找二分搜索树的最大元素
    public E maxmum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maxmum(root).e;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }


    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin(){
        E min = minimum();
        root = removeMin(root);
        return min;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax(){
        E max = maxmum();
        root = removeMax(root);
        return max;
    }

    /***删除指定值*/

    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根

    private Node remove(Node node, E e){
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
        }
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
        }
            if(e.compareTo(node.e) == 0){
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                return leftNode;
            }
                // 待删除节点左右子树均不为空的情况
                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;

                node.left = node.right = null;

                return successor;

        }
        return null;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    /**打印节点*/

    private String generateDepthString(int depth){
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i< depth; i++){
            sb.append("--");
        }
        return sb.toString();
    }


    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuffer sb){
        if(node == null){
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }
        sb.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth+1, sb);
        generateBSTString(node.right, depth+1, sb);
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }
}
