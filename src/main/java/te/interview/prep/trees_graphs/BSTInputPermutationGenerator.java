package te.interview.prep.trees_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * 4.9 Generate all possible permutations of input for a BST
 * //TODO: Review, the recursion is a little tricky here too
 */
public class BSTInputPermutationGenerator {

    public List<LinkedList<Integer>> generate(TreeNode node) {
        List<LinkedList<Integer>> results = new ArrayList<>();

        // Base case - we have reached the end of the tree
        if (node == null) {
            // This is necessary, otherwise we won't get into the for-loop for leaf nodes
            // which will cascade up our recursive calls causing us to return an empty list
            results.add(new LinkedList<>());
            return results;
        }

        // Where we store the permutations we build up
        LinkedList<Integer> permutationBuffer = new LinkedList<>();
        permutationBuffer.add(node.data);

        List<LinkedList<Integer>> leftSubtree = generate(node.left);
        List<LinkedList<Integer>> rightSubtree = generate(node.right);

        for (LinkedList<Integer> left : leftSubtree) {
            for (LinkedList<Integer> right : rightSubtree) {
                new LinkedListWeaver().weave(left, right, permutationBuffer, results);
            }
        }

        return results;
    }

}
