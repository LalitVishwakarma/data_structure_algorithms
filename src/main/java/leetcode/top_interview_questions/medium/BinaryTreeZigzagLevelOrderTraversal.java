package leetcode.top_interview_questions.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        queue.offer(null);

        boolean sw = true;

        List<Integer> level = new ArrayList();

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {

                if(queue.size() > 0)
                    queue.offer(null);
                result.add(level);

                sw = !sw;


                level = new ArrayList();
            } else {
                level.add(node.val);
                if(sw) {
                    if(node.right != null)
                        queue.add(node.right);
                    if(node.left != null)
                        queue.add(node.left);
                } else {
                    if(node.left != null)
                        queue.add(node.left);
                    if(node.right != null)
                        queue.add(node.right);
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal orderTraversal = new BinaryTreeZigzagLevelOrderTraversal();

        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(3);

        rootNode.left.left = new TreeNode(4);
        rootNode.right.right = new TreeNode(5);

        List<List<Integer>> result = orderTraversal.zigzagLevelOrder(rootNode);
        System.out.println(result.toString());

    }
}
