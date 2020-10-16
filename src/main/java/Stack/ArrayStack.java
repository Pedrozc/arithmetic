package Stack;

import Array.Array;

/**栈时间复杂度
 *
 *
 *
 */

public class ArrayStack<E> implements Stack<E>{

    private Array<E> array;

    public ArrayStack(int capacity){
        array = new Array(capacity);
    }

    public ArrayStack(){
        array = new Array();
    }


    public int getSize() {
        return 0;
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void push(E e) {
        array.addLast(e);
    }

    public E pop() {
        return array.removeLast();
    }

    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Stack: ");
        sb.append("[");
        for (int i = 0; i< array.getSize(); i++){
            sb.append(array.get(i));
            if(i != array.getSize() - 1){
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }

}
