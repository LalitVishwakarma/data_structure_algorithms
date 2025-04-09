package interviews;

public class InOrderTraversal {

    TreeNode2 root;

    public static class TreeNode2 {
        int data;
        TreeNode2 left;
        TreeNode2 right;

        TreeNode2(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void inOrderTraversal(TreeNode2 root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrderTraversal(root.left);
        }
        System.out.println(root.data);
        if (root.right != null) {
            inOrderTraversal(root.right);
        }
    }

    public static TreeNode2 trimTree(TreeNode2 root, int left, int right) {
        if (root == null)
            return null;


        if (root.data > right) {
            return trimTree(root.right, left, right);
        } else if(root.data < left) {
            return trimTree(root.left, left, right);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(10);
        root.left = new TreeNode2(5);
        root.right = new TreeNode2(15);
        root.left.left = new TreeNode2(1);
        root.left.right = new TreeNode2(6);
        root.right.left = new TreeNode2(11);
        root.right.right = new TreeNode2(20);

        inOrderTraversal(root);
        root = trimTree(root, 1, 20);
        System.out.println("=======");
        inOrderTraversal(root);

    }
}
