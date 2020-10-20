package Map;

public class LinkedListMap<K, V> implements Map<K, V>{

    private class Node{
        public K key;
        public V value;
        public Node next;
        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(){
            this(null, null, null);
        }

        public Node(K key, V value){
            this(key, value, null);
        }

        @Override
        public String toString(){
            return key.toString() + ": " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }
    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key, value, dummyHead.next);
        }else {
            node.value = value;
        }
    }

    public V remove(K key) {
        Node cur = dummyHead;
        while(cur.next != null){
            if(cur.next.key.equals(key)){
                Node pre = cur.next;
                cur.next = cur.next.next;
                return pre.value;
            }
            cur = cur.next;
        }
        return null;
    }

    public boolean contains(K key) {
        return getNode(key) != null;
    }

    public V get(K key) {
        return null;
    }

    public void set(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = value;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString(){
        Node cur = dummyHead;
        StringBuffer sb = new StringBuffer();
        sb.append("map:[");
        while(cur.next != null){
            sb.append(cur.next.key + "=" + cur.next.value);
            if(cur.next.next != null){
                sb.append(", ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
