package Queque;

import org.omg.CORBA.Object;

public class LoopQueque<E> implements Queque<E>{

    private E[] data;
    private int front, tail;
    private int Size;

    public LoopQueque(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        Size = 0;
    }

    public LoopQueque(){
        this(10);
    }

    public int getCapity(){
        return data.length - 1;
    }

    public int getSize() {
        return Size;
    }

    public boolean isEmpty() {
        return front == tail;
    }


    public void enqueue(E e) {

    }

    public E dequeue() {
        return null;
    }

    public E getFront() {
        return null;
    }
}
