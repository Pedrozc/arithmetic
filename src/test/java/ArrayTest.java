import Array.Array;

public class ArrayTest {
    public static void main(String[] args) {
        Array array = new Array(15);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);
        array.addLast(6);
        array.addLast(7);
        array.addLast(8);
        array.addLast(9);
        System.out.println(array.toString());
        System.out.println("==========================");
        array.add(4,10);
        System.out.println(array.toString());
        System.out.println("-----------------------------");
        System.out.println("the array's capacity====== "  + array.getCapacity());
    }
}
