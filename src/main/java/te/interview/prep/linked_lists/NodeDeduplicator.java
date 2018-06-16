package te.interview.prep.linked_lists;

import te.interview.prep.linked_lists.domain.Node;

import java.util.HashSet;
import java.util.Set;

public class NodeDeduplicator {

    Node deduplicate(Node head) {
        Set<Integer> uniqueValues = new HashSet<>();
        uniqueValues.add(head.data);

        Node n = head;
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
