package Queque;

import org.omg.CORBA.Object;

public class LoopQueque<E> implements Queque<E>{

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueque(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueque(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    public int getSize() {
        return size;
        //front >= tail ? tail + data.length - front : tail - front;
    }

    public boolean isEmpty() {
        return front == tail;
    }


    public void enqueue(E e) {
        if((tail +1)% data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail +1) % data.length;
        size ++;
    }

    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() /4 && getCapacity() / 2 != 0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    public void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[(i + front) % data.length];
            data = newData;
            front = 0;
            tail = size;
        }
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        sb.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            sb.append(data[i]);
            if((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
