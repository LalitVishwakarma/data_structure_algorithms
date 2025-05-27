package Challange500;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists23 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
            this.next = null;
        }
    }

    public ListNode mergeKListsWithPriorityQueue(ListNode[] lists) { //n* log k
        if (lists.length == 0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode node : lists) {
            if (node != null)
                queue.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            pointer.next = node;
            pointer = pointer.next;

            if(node.next != null)
                queue.offer(node.next);
        }

        return dummy.next;
    }

    public ListNode mergeKListsWithMergeSort(ListNode[] lists) { //n* log k
        if (lists.length == 0)
            return null;
        return divideNConquer(lists, 0, lists.length - 1);
    }

    private ListNode divideNConquer(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];

        int mid = (left + right) / 2;
        ListNode l1 = divideNConquer(lists, left, mid);
        ListNode l2 = divideNConquer(lists, mid + 1, right);
        return merge2List(l1, l2);
    }

    private ListNode merge2List(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val < l2.val){
            l1.next = merge2List(l1.next, l2);
            return l1;
        } else {
            l2.next = merge2List(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeKListsWithLoop(ListNode[] lists) { //n*n
        ListNode newList = null;
        ListNode prev = null;

        boolean completed = false;
        while(!completed) {
            int min = Integer.MAX_VALUE;
            ListNode minPointer = null;
            int index = -1;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    minPointer = lists[i];
                    index = i;
                }
            }
            if(newList == null) {
                newList = minPointer;
                prev = minPointer;
            } else {
                prev.next = minPointer;
                prev = minPointer;
            }

            if(index == -1)
                completed = true;
            else
                lists[index] = minPointer != null ? minPointer.next : null;
        }
        return newList;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);

        ListNode[] arr = {listNode1, listNode2, listNode3};
        MergeKSortedLists23 mergeKSortedLists23 = new MergeKSortedLists23();
        ListNode result = mergeKSortedLists23.mergeKListsWithPriorityQueue(arr);
        System.out.println(result);
    }

}
