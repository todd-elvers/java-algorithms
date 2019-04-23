package te.interview.prep.linked_lists.domain;

/**
 * Leetcode's implementation of a LinkedList.
 * <p>
 * I made this instead of reusing the others I made during Cracking The Coding Interview
 * so that I could copy my answers from leetcode straight to here with minimal changes.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode create(int... elements) {
        if (elements.length == 0) return null;

        ListNode head = new ListNode(elements[0]);
        ListNode n = head;
        for (int i = 1; i < elements.length; i++) {
            n.next = new ListNode(elements[i]);
            n = n.next;
        }

        return head;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode n = this;

        while(n.next != null) {
            sb.append(n.val);
            sb.append(" -> ");
            n = n.next;
        }

        sb.append(n.val);

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ListNode)) return false;

        return this.toString().equals(obj.toString());
    }
}