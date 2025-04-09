package practice;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeDepth {
    public static int dfs(TreeNode node) {
        if(node == null)
            return 0;
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
    }
    public static int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<TreeNode> a = new ArrayList<>();
        a.add(new TreeNode(10));
        for (TreeNode t : a) {
            System.out.println(t.val);
        }
        System.out.println(maxDepth(root));
    }
}
