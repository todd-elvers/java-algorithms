package te.interview.prep.linked_lists;

import te.interview.prep.linked_lists.domain.ListNode;

public class SortedListMerger {

    public ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = null, tail = null;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                tail = setNext(tail, l1.val);
                l1 = l1.next;
            } else {
                tail = setNext(tail, l2.val);
                l2 = l2.next;
            }

            head = (head == null) ? tail : head;
            tail = (tail.next == null) ? tail : tail.next;
        }

        ListNode leftOver = (l1 == null) ? l2 : l1;
        while(leftOver != null) {
            tail = setNext(tail, leftOver.val);
            tail = tail.next;
            leftOver = leftOver.next;
        }

        return head;
    }

    private ListNode setNext(ListNode tail, int val) {
        if(tail == null) {
            return new ListNode(val);
        } else {
            tail.next = new ListNode(val);
            return tail;
        }
    }
}
