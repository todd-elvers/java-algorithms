package te.interview.prep.linked_lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

import te.interview.prep.linked_lists.domain.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Problem on leetcode</a>
 */
public class SortedLinkedListMerger {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        // Space complexity = O(n) where n is the sum of the lengths of k lists
        // Time  complexity = O(1) in the average case, O(log n) in the worst case
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode node : lists) {
            while(node != null) {
                minHeap.add(node.val);
                node = node.next;
            }
        }

        // Time complexity = O(log n) for each operation, so O(n log n) for all operations
        ListNode head = null, tail = null;
        while(!minHeap.isEmpty()) {
            // Edge case: head & tail are null on first iteration
            if(tail == null) {
                tail = new ListNode(minHeap.poll());
                head = tail;
            } else {
                tail.next = new ListNode(minHeap.poll());
                tail = tail.next;
            }
        }

        return head;
    }

}
