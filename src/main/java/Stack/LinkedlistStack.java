package Stack;

import List.LinkedList;

import java.util.List;

public class LinkedlistStack<E> implements Stack<E>{

    private LinkedList<E> linkedList;

    public LinkedlistStack(){
        linkedList = new LinkedList();
    }

    public int getSize() {
        return linkedList.getSize();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public void push(E e) {
        linkedList.addFirst(e);
    }

    public E pop() {
        return linkedList.removeFirst();
    }

    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Stack: top ");
        sb.append(linkedList);
        return sb.toString();
    }
}
