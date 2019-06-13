package te.interview.prep.linked_lists;

import java.util.PriorityQueue;

import te.interview.prep.linked_lists.domain.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Problem on leetcode</a>
 */
public class SortedLinkedListMerger {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        // Space complexity = O(n) where n is the sum of the lengths of k lists
        // Time  complexity = O(log n) for insert
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                minHeap.add(node.val);
                node = node.next;
            }
        }

        // Time complexity = O(log n) for each operation, so O(n log n) for all operations
        ListNode head = null, tail = null;
        while (!minHeap.isEmpty()) {
            // Edge case: head & tail are null on first iteration
            if (tail == null) {
                head = tail = new ListNode(minHeap.poll());
            } else {
                tail.next = new ListNode(minHeap.poll());
                tail = tail.next;
            }
        }

        return head;
    }

}
