package te.interview.prep.trees_graphs;

import java.util.Arrays;
import java.util.LinkedList;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">Problem on
 * leetcode</a>
 */
public class BinaryTreeSerializationService {
    // While the empty string is more efficient here 'null' is more readable & easier to visualize
    private static final String EMPTY_NODE = "null";
    private static final String DELIMITER = ",";

    public String serialize(TreeNode root) {
        if (root == null) return EMPTY_NODE;

        StringBuilder result = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            result.append(node == null ? EMPTY_NODE : node.data);

            if (node != null) {
                queue.addLast(node.left);
                queue.addLast(node.right);
            }

            if(!queue.isEmpty()) result.append(DELIMITER);
        }

        return result.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        LinkedList<String> valueQueue = new LinkedList<>(Arrays.asList(data.split(",")));

        TreeNode head = getNextNode(valueQueue);
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.addLast(head);

        while (!valueQueue.isEmpty()) {
            TreeNode node = nodeQueue.removeFirst();

            node.left = getNextNode(valueQueue);
            if (node.left != null) {
                nodeQueue.addLast(node.left);
            }

            node.right = getNextNode(valueQueue);
            if (node.right != null) {
                nodeQueue.addLast(node.right);
            }
        }

        return head;
    }

    private TreeNode getNextNode(LinkedList<String> queue) {
        if(queue.isEmpty()) return null;

        String nextValue = queue.removeFirst();

        return nextValue.equals(EMPTY_NODE)
                ? null
                : new TreeNode(Integer.parseInt(nextValue));
    }

}
