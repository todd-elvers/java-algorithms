package te.interview.prep.stacks_queues;

import java.util.EmptyStackException;

import te.interview.prep.linked_lists.domain.Node;

/**
 * 3.2 from Cracking the Coding Interview
 *
 * @see <a href="https://leetcode.com/problems/min-stack/">Similar problem on leetcode</a>
 */
public class MinStack extends BasicStack<Integer> {
    static class MinNode extends Node<Integer> {
        Integer substackMinimum;

        MinNode(Integer data, Integer substackMinimum, Node<Integer> next) {
            super(data);
            this.substackMinimum = substackMinimum;
            this.next = next;
        }
    }

    @Override
    public void push(Integer item) {
        top = new MinNode(item, determineNewMin(item), top);
    }

    private int determineNewMin(int newData) {
        return (top == null) ? newData : Math.min(newData, min());
    }

    public Integer min() {
        if (top == null) throw new EmptyStackException();   // Leetcode impl doesn't support exceptions
        return ((MinNode) top).substackMinimum;
    }
}
