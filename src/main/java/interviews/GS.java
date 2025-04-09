//// /*
////  * Click `Run` to execute the snippet below!
////  */
//
//import java.io.*;
//import java.util.*;
//
//// /*
////  * To execute Java, please define "static void main" on a class
////  * named Solution.
////  *
////  * If you need more classes, simply define them inline.
////  */
//
//class Node {
//    Node next;
//    int data;
//
//    Node(int data){
//        this.data = data;
//        this.next = null;
//    }
//
//}
//// class Solution {
//
////   static Node deleteDuplicate(Node head){
//
//
//
//
////     if(head == null)
////       return null;
//
////     Map<Integer, Integer> map = new HashMap<>();
//
////     Node current = head.next;
//
////     map.put(head.data, 1);
//
////     Node prev = head;
////     while(current != null){
//
////       if(map.containsKey(current.data)) {
////         //delete Node
//
////         prev.next = current.next;
//
//
////       } else {
//
////         map.put(current.data, 1);
////         prev = current;
////       }
//
////       current = current.next;
////     }
//
////     return head;
////   }
////   public static void main(String[] args) {
//
//
////     ArrayList<String> strings = new ArrayList<String>();
////     strings.add("Hello, World!");
////     strings.add("Welcome to CoderPad.");
////     strings.add("This pad is running Java " + Runtime.version().feature());
////     Node start = new Node(10);
////         start.next = new Node(12);
////         start.next.next = new Node(11);
////         start.next.next.next = new Node(11);
////         start.next.next.next.next = new Node(12);
////         start.next.next.next.next.next = new Node(11);
////         start.next.next.next.next.next.next = new Node(10);
//
////     // for (String string : strings) {
////     //   System.out.println(string);
////     // }
//
////     start = deleteDuplicate(start);
//
////     Node current = start;
//
////     while(current != null){
////       System.out.println(current.data);
////       current = current.next;
////     }
//
//
////   }
//// }
//
//
//// /// Micro Service Architecture
//
//// /// 4xx & 5xx Error
//
//// /// Authentication / Authorization
//
//// /// Handling if any service go down
//
//
//// /*A robot is located at the top-left corner of a m x n grid.
//
//// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
//
//// How many possible unique paths are there?
//
//
//// Example 1:
//
//
//// Input: m = 3, n = 7
//// Output: 28
//// Example 2:
//
//// Input: m = 3, n = 2
//// Output: 3
//// Explanation:
//// From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//// 1. Right -> Down -> Down
//// 2. Down -> Down -> Right
//// 3. Down -> Right -> Down
//// Example 3:
//
//// Input: m = 7, n = 3
//// Output: 28 */
//
//
//// 0 0 0 0
//// 0 1 1 1
//// 0 1 2 3
//
//// class Solution {
//
////     public static long getCount(int m, int n){
//
////       long res[][] = new long[m+1][n+1];
//
////       for(int i = 0; i < m+1; i++){
////         res[i][0] = 0;
////       }
////       for(int i = 0; i < n+1; i++){
////         res[0][i] = 0;
////       }
//
////       res[1][1] = 1;
//
////       for(int i = 1; i <= m; i++){
////         for(int j = 1; j <= n; j++){
////           res[i][j] = res[i-1][j] + res[i][j];
////           res[i][j] = res[i][j-1] + res[i][j];
////         }
////       }
//
//// //       for(int i = 0; i <= m; i++){
//// //         for(int j = 0; j <= n; j++){
//// //           System.out.println(" "+ res[i][j]);
//// //         }
//// //         System.out.println();
//// //       }
//
////       return res[m][n];
////     }
//
////     public static void main(String[] args) {
//
//
//// //     ArrayList<String> strings = new ArrayList<String>();
//// //     strings.add("Hello, World!");
//// //     strings.add("Welcome to CoderPad.");
//// //     strings.add("This pad is running Java " + Runtime.version().feature());
//// //     Node start = new Node(10);
//// //         start.next = new Node(12);
//// //         start.next.next = new Node(11);
//// //         start.next.next.next = new Node(11);
//// //         start.next.next.next.next = new Node(12);
//// //         start.next.next.next.next.next = new Node(11);
//// //         start.next.next.next.next.next.next = new Node(10);
//
//// //     // for (String string : strings) {
//// //     //   System.out.println(string);
//// //     // }
//
//// //     start = deleteDuplicate(start);
//
//// //     Node current = start;
//
//// //     while(current != null){
//// //       System.out.println(current.data);
//// //       current = current.next;
//// //     }
//
////       System.out.println(getCount(18, 18));
//
////   }
//// }
//
//
//
//a->b->c->a1->b1->c1->.........an->bn->cn
//        b->c->a->b1->c1->a1->........ bn->cn->an
//
//
//
//        h-> p -> a b current -> c next -> a1
//
//
//class Solution {
//
//
//
//    public Node replaceThird(Node head){
//
//        if(head == null){
//            return null;
//        }
//
//
//        Node prev = head;
//        Node current = head;
//
//        Node prev1 ;
//        Node next = current.next;
//
//        while(current.next.next != null){
//            current = current.next.next;
//            next = current.next;
//            current.next = prev;
//
//            prev1.next = prev;
//
//            if(next != null){
//                current = next;
//                prev = next;
//                prev1 = prev;
//            }
//
//
//        }
//
//        head = head.next;
//        return head;
//    }
//
//    public static void main(String[] args) {
//
//
//    }
//}
//
//
//
//current -> a
//        next -> b;
//        prev -> a;
//
//
//        current -> c;
//        next -> a1;
//        prev -> a;
//
//        b -> c -> a -> a1 -> b1 -> c1 -> a2
//
//        current -> c1
//        prev -> a1 -> a2
//        next -> a2
//
////
//        curre
//


//third round

/*
 * Click `Run` to execute the snippet below!
 */

//import java.io.*;
//import java.util.*;
//
///*
// * To execute Java, please define "static void main" on a class
// * named Solution.
// *
// * If you need more classes, simply define them inline.
// */
//
//class Node {
//    String data;
//    List<Node> list = new practice.interviews.LinkedList<>();
//
//    add(Node n){
//        list.add(n);
//    }
//
//    Node(String data){
//        this.data = data;
//    }
//}
//
//class Tree {
//    Node root;
//}
//
//class Solution {
//    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<String>();
//        strings.add("Hello, World!");
//        strings.add("Welcome to CoderPad.");
//        strings.add("This pad is running Java " + Runtime.version().feature());
//
//        Node c = new Node("c");
//
//
//        Tree t = new Tree();
//
//
//        //
//        Map<String, String> map = new HashMap<>();
//
//        for(int i = 0; i < rows.length; i++){
//            rows[]
//        }
//
//
//        for (String string : strings) {
//            System.out.println(string);
//        }
//    }
//}

/*
Name  Parent
D      C
C      B
B      A
A
X      C
Y
Z     X
A -> B -> C -> D

*/
