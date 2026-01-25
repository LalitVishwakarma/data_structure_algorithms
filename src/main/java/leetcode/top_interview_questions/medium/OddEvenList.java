package leetcode.top_interview_questions.medium;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;

        ListNode head2 = head.next;

        ListNode odd = head;
        ListNode even = head.next;

        while(even != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;

        }

        odd.next = head2;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        OddEvenList oddEvenList = new OddEvenList();

        ListNode result = oddEvenList.oddEvenList(head);

        oddEvenList.printList(result);


    }

    private void printList(ListNode result) {
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
