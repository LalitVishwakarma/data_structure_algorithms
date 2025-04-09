package practice;

public class SumRootToLeaf {

    public int dfs(TreeNode node, int res) {
        if(node.left == null && node.right == null) {
            System.out.println(" " + res);
            return res;
        }

        int sum = node.val;
        if(node.left != null)
            sum += dfs(node.left, (res + node.val) * 10);
        if(node.right != null)
            sum += dfs(node.right, (res + node.val) * 10);
        return sum;
    }
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return dfs(root, 0);
    }
}
