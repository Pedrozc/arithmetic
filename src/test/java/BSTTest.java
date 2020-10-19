import BSTree.BST;

public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST();
        int[] nums = {5, 3, 8, 7,11, 4, 2};
        for(int num: nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    8    //
        //  / \  / \   //
        // 2  4  7  11  //
        /////////////////
        bst.preOrder();
        System.out.println();
        bst.removeMin();
        System.out.println(bst.toString());


//        bst.inOrder();
//        System.out.println();
//
//        bst.postOrder();
//        System.out.println();
    }
}
