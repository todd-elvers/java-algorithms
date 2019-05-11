package te.interview.prep.trees_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 4.9 Helper function for determining all possible permutations of input for a BST
 * //TODO: Review this, recursion was complicated here since we had to undo our changes to the input args
 */
public class LinkedListWeaver {

    public List<LinkedList<Integer>> weave(LinkedList<Integer> first, LinkedList<Integer> second) {
        List<LinkedList<Integer>> results = new ArrayList<>();
        weave(first, second, new LinkedList<>(), results);
        return results;
    }

    public void weave(LinkedList<Integer> first, LinkedList<Integer> second, LinkedList<Integer> prefix, List<LinkedList<Integer>> results) {
        // Base case: either first or second is empty
        if(first.isEmpty() || second.isEmpty()) {
            LinkedList<Integer> copyOfPrefix = new LinkedList<>(prefix);
            copyOfPrefix.addAll(first);
            copyOfPrefix.addAll(second);
            results.add(copyOfPrefix);
            return;
        }

        prefix.addLast(first.removeFirst());        // Head of 'first' appended to tail of 'prefix'
        weave(first, second, prefix, results);      // Recurse
        first.addFirst(prefix.removeLast());        // Undo changes to head of 'first' and tail of 'prefix'

        prefix.addLast(second.removeFirst());
        weave(first, second, prefix, results);
        second.addFirst(prefix.removeLast());
    }
}
