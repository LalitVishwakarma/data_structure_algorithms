package interviews;

class BST {

    BST left, right;
    int data;

    BST(int value){
        this.left = null;
        this.right = null;
        data = value;
    }
}

public class TestMS {
    static int count = 0;

    public static void inorder(BST root, int k){
        if(root.left != null) {
            inorder(root.left, k);
        }

        if(++count == k) {
            System.out.println("the " + k + "th smallest element is " + root.data);
        }

        if(root.right != null) {
            inorder(root.right, k);
        }
    }

    public static void main(String[] args) {
        BST root = new BST(20);
        root.left = new BST(15);
        root.right = new BST(30);
        root.left.left = new BST(10);
        root.left.right = new BST(18);
        root.right.left = new BST(25);
        root.right.right = new BST(35);

        inorder(root, 5);
    }

}
