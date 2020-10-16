package Stack;
//栈，先进后出
public interface Stack<E>{

    //获取栈深
    int getSize();
    //是否为空
    boolean isEmpty();
    //进栈
    void push(E e);
    //输出并删除栈顶元素
    E pop();
    //输出不删除栈顶元素
    E peek();
}
