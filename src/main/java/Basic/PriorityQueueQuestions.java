package Basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class PriorityQueueQuestions {

    public int findKthLargestElement(int[] nums, int k) {
        // (a, b) -> a.compareTo(b) -> min heap
        // (a, b) -> b.compareTo(a) -> max heap
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> a.compareTo(b));

        for(int n : nums) {
            queue.add(n);
        }
        int i = 1;
        while(i < k && !queue.isEmpty()) {
            queue.poll();
            i++;
        }
        return queue.isEmpty() ? -1 : queue.poll();
    }


    public ListNode mergeKSortedList(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val );

        for (ListNode node: lists) {
            queue.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.offer(tail.next);
            }
        }
        return dummy.next;
    }

    public String frequencySort(String input) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        queue.addAll(map.entrySet());

        StringBuilder stringBuilder = new StringBuilder();

        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            stringBuilder.repeat(entry.getKey(), entry.getValue());
        }

        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        PriorityQueueQuestions pqq = new PriorityQueueQuestions();
        int[] nums = {12, 45, 2, 67, 33, 89, 1, 0, -4};
        System.out.println(pqq.findKthLargestElement(nums, 1));

        // Create example lists
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = { l1, l2, l3 };

        // Call merge method
        PriorityQueueQuestions test = new PriorityQueueQuestions();
        ListNode result = test.mergeKSortedList(lists);

        ListNode head = result;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println(pqq.frequencySort("programming"));
    }
}
