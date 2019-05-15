package te.interview.prep.strings_arrays;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/flatten-nested-list-iterator/">Problem on
 * leetcode</a>
 */
public class ListFlattener implements Iterator<Integer> {
    private Stack<NestedInteger> stack = new Stack<>();

    public ListFlattener(List<NestedInteger> nestedList) {
        reversePushAll(nestedList);
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) {
                return true;
            } else {
                reversePushAll(stack.pop().getList());
            }
        }

        return false;
    }

    private void reversePushAll(List<NestedInteger> nested) {
        for (int i = nested.size() - 1; i >= 0; i--) {
            stack.push(nested.get(i));
        }
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    interface NestedInteger {

        /**
         * @return true if this ListFlattener holds a single integer, rather than a nested list
         */
        boolean isInteger();

        /**
         * @return the single integer that this ListFlattener holds, if it holds a single integer.
         * Edge-case: returns null if this NestedInteger holds a nested list
         */
        Integer getInteger();

        /**
         * @return the nested list that this ListFlattener holds, if it holds a nested list.
         * Edge-case: return null if this ListFlattener holds a single integer
         */
        List<NestedInteger> getList();
    }
}






