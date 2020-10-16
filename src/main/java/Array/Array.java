package Array;


//创建数组
public class Array<E> {
    //数据
    private E[] data;
    //数组容量
    private int size;
/**
 * 数组可以时间复杂度分析
 * 查询   O(1)
 * 插入   O(n)
 * 删除   O(n)
 *
 */




    /****基本构造器和方法***/
    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize(){
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer("[");
        for (int i = 0; i<size; i++){
            if(i <size -1) {
                stringBuffer.append(data[i] + ",");
            }else {
                stringBuffer.append(data[i]);

            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /***添加元素**/
    // 向所有元素后添加一个新元素
    public void addLast(E e){
        add(size, e);
    }


    // 在所有元素前添加一个新元素
    public void addFirst(E e){
        add(0,e);
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, E e){
        if (size == data.length){
            throw new IllegalArgumentException("Add failed. Array is full.");
        }
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 or index <= size.");
        }

        if(index == data.length){
            resize(2* data.length);
        }

        for (int i = size ; i > index ; i--){
            data[i] = data[i-1];
        }
        data[index] = e;
        size ++;
    }

    /**获取/修改 元素**/

    // 获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    public E getLast(){
        return get(size -1);
    }

    public E getFirst(){
        return get(0);
    }
    /**查询元素**/

    // 查找数组中是否有元素e
    public boolean contains(int e){
        for (int i = 0; i< size; i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }


    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for (int i = 0; i< size; i++){
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }


    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index){
        if (index <0 || index >= size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index + 1 ; i <size; i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        if(size == data.length/4 && data.length / 2 != 0){
            resize(data.length/2);
        }
        return ret;
    }


    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }


    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size -1);
    }


    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    /**扩容*/
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i< size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
