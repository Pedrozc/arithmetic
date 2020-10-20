package Set;

import List.LinkedList;

public class LinkedListSet<E> implements Set<E>{
    private LinkedList<E> linkedList;

    public LinkedListSet(){
        linkedList = new LinkedList();
    }

    public void add(E e) {
        if(!linkedList.contains(e)){
            linkedList.addFirst(e);
        }
    }

    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    public void remove(E e) {
        linkedList.removeElement(e);
    }

    public int getSize() {
        return linkedList.getSize();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
