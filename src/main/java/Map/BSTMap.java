package Map;

import javax.xml.bind.ValidationEvent;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value){
        if(node == null){
            return new Node(key, value);
        }
        if(key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
            return node;
        }
        if(key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
            return node;
        }
        node.value = value;
        return node;
    }

    // 向二分搜索树中添加新的元素(key, value)
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node remove(Node node, K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            return node;
        }
        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        }
        //删除节点
        // 待删除节点左子树为空的情况
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }else {
            // 待删除节点右子树为空的情况
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

    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null) {
            return node;
        }
        return minimum(node.left);
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

    public V remove(K key) {
        Node cur = getNode(root, key);
        if(cur == null){
            return null;
        }
        root = remove(root, key);
        return cur.value;
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key){
        if(node != null){
            if(key.compareTo(node.key) > 0){
                getNode(node.left, key);
            }
            if(key.compareTo(node.key) < 0){
                getNode(node.right, key);
            }
            return node;
        }
        return null;
    }

    public V get(K key) {
        return getNode(root, key).value;
    }

    public void set(K key, V value) {

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
