package te.interview.prep.linked_lists;

import te.interview.prep.linked_lists.domain.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

public class NodeDeduplicator {

    // O(n)
    LinkedListNode deduplicate(LinkedListNode head) {
        Set<Integer> uniqueValues = new HashSet<>();
        uniqueValues.add(head.data);

        LinkedListNode n = head;
        while (n.next != null) {
            if (uniqueValues.contains(n.next.data)) {
                n.next = n.next.next;
            } else {
                uniqueValues.add(n.next.data);
                n = n.next;
            }
        }

        return head;
    }

}
