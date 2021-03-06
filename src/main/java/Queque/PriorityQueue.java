package Queque;

import Heap.MaxHeap;

public class PriorityQueue<E extends Comparable<E>> implements Queque<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<E>();
    }

    public int getSize() {
        return maxHeap.getSize();
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    public void enqueue(E e) {
        maxHeap.add(e);
    }

    public E dequeue() {
        return maxHeap.extractMax();
    }

    public E getFront() {
        return maxHeap.findMax();
    }
}
