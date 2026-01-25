package leetcode.top_interview_questions.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {

        if(inStart > inEnd || preStart > preEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStart]);

        int inIndex = map.get(preorder[preStart]);

        int left = inIndex - inStart;

        node.left = buildTree(preorder, preStart + 1, preStart + left, inorder, inStart, inIndex - 1, map);
        node.right = buildTree(preorder, preStart + left + 1, preEnd, inorder, inIndex + 1, inEnd, map);
        return node;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public static void main(String[] args) {
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};

        ConstructBinaryTreefromPreorderAndInorderTraversal traversal = new ConstructBinaryTreefromPreorderAndInorderTraversal();

        TreeNode root = traversal.buildTree(preOrder, inOrder);

    }
}
