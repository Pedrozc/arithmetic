package Queque;

public interface Queque<E> {
    //队列长度
    int getSize();
    //队列是否为空
    boolean isEmpty();
    //入列
    void enqueue(E e);
    //出列
    E dequeue();
    //获取队列中第一个元素
    E getFront();
}
