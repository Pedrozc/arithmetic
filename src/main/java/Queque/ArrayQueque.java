package Queque;

import Array.Array;
//队列是先进先出
public class ArrayQueque<E> implements Queque<E>{

    private Array<E> array;

    public ArrayQueque(int capacity){
        array = new Array<E>(capacity);
    }

    public ArrayQueque(){
        array = new Array<E>();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void enqueue(E e) {
        array.addLast(e);
    }

    public E dequeue() {
        return array.removeFirst();

    }

    public E getFront() {
        return array.getFirst();
    }

    public int getCapacity(){
        return array.getCapacity();
    }
}
