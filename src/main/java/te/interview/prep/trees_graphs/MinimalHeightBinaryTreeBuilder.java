package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * 4.2
 */
public class MinimalHeightBinaryTreeBuilder {

    public TreeNode build(int[] sortedInput) {
        return buildMinimalTree(sortedInput, 0, sortedInput.length - 1);
    }

    private TreeNode buildMinimalTree(int[] sortedInput, int start, int end) {
        // Base case: line 24 generates a call with a negative end
        if(end < start) {
            return null;
        }

        int middle = (start + end) / 2;

        TreeNode root = new TreeNode(sortedInput[middle]);

        root.left = buildMinimalTree(sortedInput, start, middle - 1);
        root.right = buildMinimalTree(sortedInput, middle + 1, end);

        return root;
    }


}
