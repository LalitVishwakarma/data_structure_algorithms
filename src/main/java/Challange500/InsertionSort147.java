package Challange500;

public class InsertionSort147 {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    ListNode insertNode(ListNode head, int data) {
        ListNode node = new ListNode(data);
        if(head == null)
            return node;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null && curr.data < data) {
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) {
            // Insert at the beginning
            node.next = head;
            head = node;
        } else {
            // Insert in the middle or end
            node.next = curr;
            prev.next = node;
        }
        return head;
    }

    ListNode insertionSort(ListNode head) {
        // add your logic here
        ListNode headNew = null;

        ListNode curr = head;
        while(curr != null) {

            headNew = insertNode(headNew, curr.data);

            curr = curr.next;
        }

        return headNew;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next.next.next = new ListNode(8);

        InsertionSort147 insertionSort147 = new InsertionSort147();
        ListNode result = insertionSort147.insertionSort(head);

        while (result != null) {
            System.out.println(result.data  + " ");
            result = result.next;
        }
    }
}
