package te.interview.prep.stacks_queues.domain;

import java.util.EmptyStackException;

import te.interview.prep.linked_lists.domain.Node;

/**
 * 3.2
 */
public class MinStack extends MyStack<Integer> {
    static class MinNode extends Node<Integer> {
        Integer substackMinimum;
        MinNode(Integer data, Integer substackMinimum) {
            super(data);
            this.substackMinimum = substackMinimum;
        }
    }

    @Override
    public void push(Integer item) {
        Integer substackMinimum = (top == null) ? item : Math.min(item, peek());
        MinNode newTop = new MinNode(item, substackMinimum);
        newTop.next = top;
        top = newTop;
    }

    public Integer min() {
        if(top == null) throw new EmptyStackException();
        return ((MinNode) top).substackMinimum;
    }
}
