package te.interview.prep.linked_lists;

import te.interview.prep.linked_lists.domain.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">Problem on leetcode</a>
 */
public class NthFromEndRemover {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) return head;

        ListNode fast = head;
        ListNode slow = head;

        // Move fast pointer ahead n nodes
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Edge case: n points to first element in list
        if(fast == null) return slow.next;

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

}
