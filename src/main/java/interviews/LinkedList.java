package interviews;

public class LinkedList<I extends Number> {
    static Node head = null;

    static class Node {
        Node next;
        int data;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node reverseLinkedList(Node head){
        Node prev = null;
        Node next = null;
        Node current = head;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    void printLinkedList(Node head){
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    Node rotate(Node head, int k){
        if(k == 0)
            return head;
        Node current  = head;
        int count = 1;

        while(count < k && current != null){
            current = current.next;
            count++;
        }
        if(current == null)
            return head;

        Node kthNode = current;

        while(current.next != null){
            current = current.next;
        }

        current.next = head;

        head = kthNode.next;

        kthNode.next = null;

        return head;
    }

    public static void main(String[] args) {
        LinkedList<Number> list = new LinkedList<Number>();
        list.head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

//        list.printLinkedList(list.head);
//        head = list.reverseLinkedList(list.head);
        head = list.rotate(list.head, 1);
        list.printLinkedList(list.head);
    }

}
