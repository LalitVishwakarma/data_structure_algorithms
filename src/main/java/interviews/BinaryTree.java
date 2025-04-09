package interviews;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    Node right;
    Node left;
    int data;

    Node(int data){
        this.left = null;
        this.right = null;
        this.data = data;
    }
}
public class BinaryTree {

    Node root;

    static void levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node tmp = queue.remove();
            System.out.println(tmp.data);
            if(tmp.left != null){
                queue.add(tmp.left);
            }
            if(tmp.right != null){
                queue.add(tmp.right);
            }
        }

    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(70);

        levelOrderTraversal(tree.root);
    }
}
