package Heap;
//二叉堆(完全二叉树)【还有d叉堆，索引堆】
//父节点index i 左节点 2*i+1 ；右节点2*i+2，子节点 index i 父节点 (i-1)/2

//add 和 extractMax 时间复杂度都是O(logn)

import Array.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array(capacity);
    }

    public MaxHeap(){
        data = new Array();
    }

    // 返回堆中的元素个数
    public int getSize(){
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) /2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k){
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 看堆中的最大元素
    public E findMax(){
        if(data.getSize() == 0){
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }


    // 取出堆中最大元素
    public E extractMax(){
        E ret = findMax();
        data.swap(0, data.getSize() -1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k){
        while(leftChild(k) < data.getSize()){
            int i = leftChild(k);
            if(data.get(i).compareTo(data.get(i+ 1)) <0){
                i++;
            }
            if(data.get(k).compareTo(data.get(i)) >= 0){
                break;
            }
            data.swap(k, i);
            k = i;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    //将一个数组添加到堆中
    public MaxHeap(E[] arr){
        data = new Array(arr);
        if(arr.length != 1){
            for(int i = parent(arr.length - 1); i>= 0; i--){
                siftDown(i);
            }
        }
    }
}
