package te.interview.prep.linked_lists;

import te.interview.prep.linked_lists.domain.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/add-two-numbers/">Problem on leetcode</a>
 */
public class TwoNumberAdder {

    static class UsingIteration {

        /*
            Time : O(max(m,n))
                m = length of l1
                n = length of l2
            Space: O(max(m,n))
        */
        public ListNode add(ListNode l1, ListNode l2) {
            ListNode tail = null, head = null;
            int remainder = 0;

            while (l1 != null || l2 != null || remainder != 0) {
                int v1 = (l1 == null) ? 0 : l1.val;
                int v2 = (l2 == null) ? 0 : l2.val;

                int sum = v1 + v2 + remainder;
                if (sum > 9) {
                    sum -= 10;
                    remainder = 1;
                } else {
                    remainder = 0;
                }

                if (head == null) {
                    head = tail = new ListNode(sum);
                } else {
                    tail.next = new ListNode(sum);
                    tail = tail.next;
                }

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }

            return head;
        }

    }

    /*
        Time : O(max(m,n))
            m = length of l1
            n = length of l2
        Space: O(max(m,n))
    */
    static class UsingRecursion {

        ListNode add(ListNode l1, ListNode l2) {
            return add(l1, l2, 0);
        }

        private ListNode add(ListNode l1, ListNode l2, int remainder) {
            if (l1 == null && l2 == null) {
                return (remainder == 0) ? null : new ListNode(remainder);
            }

            int newSum = getValOrZero(l1) + getValOrZero(l2) + remainder;
            int newRemainder = 0;

            if (newSum > 9) {
                newSum -= 10;
                newRemainder = 1;
            }

            ListNode node = new ListNode(newSum);
            node.next = add(getNextOrNull(l1), getNextOrNull(l2), newRemainder);
            return node;
        }

        private int getValOrZero(ListNode l) {
            return (l == null) ? 0 : l.val;
        }

        private ListNode getNextOrNull(ListNode l) {
            return (l == null) ? null : l.next;
        }
    }
}
