//public class Walmart {
//
//               1
//            2     3
//          4   5  6  7
//
//    Walmart root;
//
//               boolean isFirstFound = false;
//               boolean isSecondFound = false;
//
//    static class TreeNode {
//        int data;
//        TreeNode left;
//        TreeNode right;
//    }
//
//    public TreeNode postOrder(TreeNode root,TreeNode first, TreeNode second ){
//        TreeNode isFirstfound = null;
//        TreeNode isSecondFound = null;
//        if(root.data == first.data){
//            isFirstfound = root;
//        }
//        if(root.data == second.data){
//            isSecondFound = root;
//        }
//
//        if(isFirstfound != null && isSecondFound != null){
//            System.out.println(root.data);
//            return root;
//        }
//
//        if(root.left){
//            isFirstfound = postOrder(root.left, first, second);
//            if(isFirstfound != null)
//                return root;
//        }
//
//        if(root.right){
//            isSecondFound = postOrder(root.right, first, second);
//            if(isSecondFound != null)
//                return root;
//        }
//
//
//        return null;
//    }
//
//    public boolean search(TreeNode first, TreeNode second){
//        postOrder(root, first, second);
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//}
