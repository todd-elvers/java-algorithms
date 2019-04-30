package te.interview.prep.trees_graphs;

import java.util.Random;

/**
 * 4.11 Custom BST that can return random node in tree, with all nodes having equal chance.
 * //TODO: Review, try and implement this again without looking at the code.
 */
public class ChildAwareTreeNode {

    public ChildAwareTreeNode left;
    public ChildAwareTreeNode right;
    public int data;
    private int size;

    public ChildAwareTreeNode(int data) {
        this.data = data;
        this.size = 1;
    }

    public ChildAwareTreeNode getRandomNode() {
        int leftSize = (left == null) ? 0 : left.size;
        int rand = new Random().nextInt(size);

        if (rand < leftSize) {
            return left.getRandomNode();
        } else if (rand == leftSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }

    public void insertInOrder(int newData) {
        if (newData <= data) {
            if (left == null) {
                this.left = new ChildAwareTreeNode(newData);
            } else {
                this.left.insertInOrder(newData);
            }
        } else {
            if (right == null) {
                this.right = new ChildAwareTreeNode(newData);
            } else {
                this.right.insertInOrder(newData);
            }
        }
        size++;
    }

    public ChildAwareTreeNode find(int targetData) {
        if (targetData == data) {
            return this;
        } else if (targetData < data) {
            return (left == null) ? null : left.find(targetData);
        } else {
            return (right == null) ? null : right.find(targetData);
        }
    }

    public int getSize() {
        return size;
    }


}


