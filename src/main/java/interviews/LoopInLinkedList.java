package interviews;

import java.util.HashSet;
import java.util.Set;

public class LoopInLinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void push(int data){
        Node tmp = new Node(data);
        tmp.next = head;
        head = tmp;
    }

    public static void printLL(Node head){
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static boolean detectLoop(Node h){
        Set<Node> hashTable = new HashSet<>();

        while (h != null){

            if(hashTable.contains(h)){
                return true;
            }
            hashTable.add(h);
            h = h.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LoopInLinkedList llist = new LoopInLinkedList();

        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        /*Create loop for testing */
        printLL(llist.head);
        llist.head.next.next.next.next = llist.head;


        if (detectLoop(llist.head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
    }
}
