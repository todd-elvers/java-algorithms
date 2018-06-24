package te.interview.prep.linked_lists.domain;

/**
 * Implementation of {@link Node} that throws an exception when {@link #toString()} is called
 * so that an infinite loop isn't caused.
 */
public class LoopNode<T> extends Node<T> {
    public LoopNode<T> next = null;

    public LoopNode(T data) {
        super(data);
    }

    public static <T> LoopNode<T> create(T... elements) {
        if(elements.length == 0) return null;

        LoopNode<T> head = new LoopNode<>(elements[0]);
        LoopNode<T> n = head;
        for(int i = 1; i < elements.length; i++) {
            n.next = new LoopNode<>(elements[i]);
            n = n.next;
        }

        return head;
    }

    /**
     * Nodes with loops can't easily be printed so we disable that functionality here.
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Cannot call toString() on LoopNodes.");
    }
}
