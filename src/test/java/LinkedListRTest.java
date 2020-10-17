import List.LinkedListR;

public class LinkedListRTest {

    public static void main(String[] args) {
        LinkedListR<Integer> linkedListR = new LinkedListR<Integer>();
        for(int i = 0; i < 5 ; i++){
            linkedListR.addFirst(i);
            System.out.println(linkedListR);
        }
        for(int i = 5; i < 10 ; i++){
            linkedListR.addLast(i);
            System.out.println(linkedListR);
        }
        linkedListR.removeElement(3);
        System.out.println(linkedListR);
    }
}
