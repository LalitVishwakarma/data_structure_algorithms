//import java.util.practice.interviews.LinkedList;
//import java.util.Queue;
//
//public class TreeToLinkedList {
//
//    NodeOfTree root;
//
//    public class NodeOfTree {
//        int data;
//        NodeOfTree left;
//        NodeOfTree right;
//
//    }
//
//               1
//        2           3
//    4      5     6      7
//
//
//  ////    1
//        2
//    4
//    3
//                       5
//    6
//    7
//
//    NodeOfLinkedList headOfLinkedList;
//  public class NodeOfLinkedList {
//        int data;
//        NodeOfLinkedList next;
//
//      NodeOfLinkedList(int data){
//          this.data = data;
//          this.next = null;
//      }
//
//      public void pushOperation(NodeOfLinkedList head, int data){
//          NodeOfLinkedList newNode = new NodeOfLinkedList(data);
//          NodeOfLinkedList tmp = head;
//          while(tmp.next != null){
//              tmp = tmp.next;
//          }
//          tmp.next = newNode;
//      }
//    }
//
//
//
//    public NodeOfLinkedList convert(Node root){
//
//        Queue<Node> queue = new practice.interviews.LinkedList<>();
//
//        NodeOfLinkedList list = new NodeOfLinkedList();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            Node node = queue.poll();
//            list.pushOperation(list, node.data);
//
//            if(node.left){
//                queue.add(node.left);
//            }
//
//            if(node.right){
//                queue.add(node.right);
//            }
//        }
//        return list;
//    }
//}
