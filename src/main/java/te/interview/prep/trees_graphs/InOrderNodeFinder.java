package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * 4.6 Find the next in-order successor to a given node.
 */
public class InOrderNodeFinder {

    public LinkedTreeNode find(LinkedTreeNode n) {
        if(n == null) return null;

        LinkedTreeNode inOrderSuccessor = null;

        if(n.right != null) {           // n might be a leaf node
            inOrderSuccessor = n.right;
            while(inOrderSuccessor.left != null) {
                inOrderSuccessor = inOrderSuccessor.left;
            }
        } else if (n.parent != null) {  // n might be a single node BST
            inOrderSuccessor = n.parent;
            while(inOrderSuccessor != null && inOrderSuccessor.data < n.data) {
                inOrderSuccessor = inOrderSuccessor.parent;
            }
        }

        return inOrderSuccessor;
    }

}

class LinkedTreeNode extends TreeNode {
    public LinkedTreeNode parent;
    public LinkedTreeNode left;
    public LinkedTreeNode right;

    public LinkedTreeNode(int data) {
        super(data);
    }

    public LinkedTreeNode(int data, LinkedTreeNode left, LinkedTreeNode right) {
        super(data, left, right);
//        this.left = left;
//        this.right = right;
    }
}