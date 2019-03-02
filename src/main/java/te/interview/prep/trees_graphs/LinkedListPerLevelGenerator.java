package te.interview.prep.trees_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * 4.3
 */
public class LinkedListPerLevelGenerator {

    List<LinkedList<TreeNode>> generateUsingDFS(TreeNode root) {
        List<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    private void createLevelLinkedList(TreeNode root, List<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;        // Base case

        LinkedList<TreeNode> list;

        if (lists.size() == level) {     // Need to add next level to list
            list = new LinkedList<>();
            /*
                Since levels are traversed in order, if this is the first time we've visited
                level i, we have already visited levels 0 through i-1. Therefore we can
                safely add the level to the end.
             */
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root);

        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    List<LinkedList<TreeNode>> generateUsingBFS(TreeNode root) {
        List<LinkedList<TreeNode>> lists = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            lists.add(queue);                       // Add previous level
            LinkedList<TreeNode> parents = queue;   // Go to next level
            queue = new LinkedList<>();

            for(TreeNode parent : parents) {
                if(parent.left != null) queue.add(parent.left);
                if(parent.right != null) queue.add(parent.right);
            }

        }

        return lists;
    }

}
