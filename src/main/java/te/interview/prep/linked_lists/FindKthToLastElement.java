package te.interview.prep.linked_lists;

import te.interview.prep.linked_lists.domain.LinkedListNode;

public class FindKthToLastElement {

    // O(n)
    public LinkedListNode findKthFromLastElement(LinkedListNode head, int k) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        // Move 'fast' k nodes into the list
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        if (fast == null) return slow;

        // Iterate both pointers until 'fast' is at the end at which point
        // 'slow' will be at the kth position in the linked list
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}
