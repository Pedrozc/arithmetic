import List.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i = 0; i < 5; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);
        System.out.println("=============");
        System.out.println("size====" +linkedList.getSize()+"______first====="
                +linkedList.getFirst() +"_______last====" + linkedList.getLast());
        System.out.println(linkedList.contains(1));
        System.out.println(linkedList.contains(5));
        ////////////////////////////////////
        System.out.println("==========================================");
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.removeElement(2);
        System.out.println(linkedList);

    }
}
