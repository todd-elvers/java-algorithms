package te.interview.prep.linked_lists;

import te.interview.prep.linked_lists.domain.LinkedListNode;

public class MiddleNodeDeleter {

    boolean delete(LinkedListNode node) {
        if(node == null || node.next == null) return false;

        node.data = node.next.data;
        node.next = node.next.next;

        return true;
    }

}
