package List;

import java.security.PublicKey;

public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this.e = e;
            this.next = null;
        }
        public Node(){
            this.e = null;
            this.next = null;
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize(){
        return size;
    }
    // 返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    // 在链表头添加新的元素e
    public void addFirst(E e){
        head = new Node(e,head);
        size++;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = head;
        for(int i = 0; i< index - 1; i++){
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
    }

    /**获取元素**/
    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = head;
        for(int i = 0; i < index ; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst(){
        return head.e;
        //return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size -1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = head;
        for (int i = 0; i< index; i++){
            cur = cur.next;
        }
        cur.e = e;

    }

    // 查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = head;
        while(cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /***删除****/
    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("remove failed. Illegal index.");
        }
        Node cur = head;
        if(index == 0){
            head = head.next;
        }
        for(int i = 0; i< index - 1 ; i++){
            cur = cur.next;
        }
        E e = cur.next.e;
        cur.next = cur.next.next;
        size--;
        return e;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size -1);
    }

    // 从链表中删除元素e
    public void removeElement(E e){
        if(head.e.equals(e)){
            head = head.next;
        }else {
            Node prev = head;
            while (prev != null) {
                if (prev.next.e.equals(e)) {
                    prev.next = prev.next.next;
                    break;
                }
            }
        }
    }



    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(Node cur = head ; cur != null ; cur = cur.next){
            sb.append(cur + "->");
        }
        sb.append("NULL");
        return sb.toString();
    }

}
