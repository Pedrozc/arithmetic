import Stack.ArrayStack;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack();

        for (int i = 0; i < 5; i++){
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        for (int i = 0; i < 5; i++) {
            arrayStack.pop();
            System.out.println(arrayStack);
        }
    }
}
