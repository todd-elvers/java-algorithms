package te.interview.prep.linked_lists;

import te.interview.prep.linked_lists.domain.LinkedListNode;

public class FindKthToLastElement {

    // O(n)
    public LinkedListNode findKthFromLastElement(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        // Move p1 k nodes into the list
        // k = 0
        for (int i = 0; i < k + 1; i++) {       // 1 added here so that p1 is one ahead of p2, so p2 will be last element when k = 0
            if (p1 == null) return null;
            p1 = p1.next;
        }

        // Move both pointers forward until p1 is at the end
        // At this point p2 will be at the kth element
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

}
