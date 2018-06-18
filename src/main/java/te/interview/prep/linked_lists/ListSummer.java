package te.interview.prep.linked_lists;

import te.interview.prep.linked_lists.domain.LinkedListNode;

public class ListSummer {

    LinkedListNode sum(LinkedListNode l1, LinkedListNode l2, int remainder) {
        if(l1 == null && l2 == null && remainder == 0) return null;
        if(l1 == null && l2 == null && remainder == 1) return new LinkedListNode(remainder);
        if(l1 == null) return new LinkedListNode(l2.data + remainder);
        if(l2 == null) return new LinkedListNode(l1.data + remainder);

        int newSum = l1.data + l2.data + remainder;
        int newRemainder = 0;

        if(newSum > 9) {
            newSum = newSum % 10;
            newRemainder = 1;
        }

        LinkedListNode summedNode = new LinkedListNode(newSum);
        summedNode.next = sum(l1.next, l2.next, newRemainder);

        return summedNode;
    }

}
