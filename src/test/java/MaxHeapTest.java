import Heap.MaxHeap;

public class MaxHeapTest {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(12);
        maxHeap.add(22);
        maxHeap.add(1);
        maxHeap.add(23);
        maxHeap.add(17);
        maxHeap.add(27);
        maxHeap.add(41);
        maxHeap.add(29);
        maxHeap.add(33);
        maxHeap.add(44);
        System.out.println(maxHeap.findMax());
        maxHeap.extractMax();
        System.out.println(maxHeap.findMax());

    }
}
