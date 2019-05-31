package te.interview.prep.trees_graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
    Sample problem I did with a Google engineer.

    Problem:
        Assume you have a binary tree with weights on the edges between nodes.
        Find the maximum possible weight traverse-able from the root of a binary tree and
        the nodes you traversed through to get those values.

    Input:
               A
             /   \
            10    2
           /       \
          B         C
                   /  \
                  9    5
                 /      \
                D        E
               /
              0
             /
            C

    Output:
        Weight = 11
        Path = A,C,D,F
 */
public class MaxWeightedEdgePathFinder {

    public WeightedPath findHighestWeightedPath(Node root, Map<Node, Map<Node, Integer>> edgeWeights) {
        return new StatefulWeightedPathFinder().find(root, edgeWeights);
    }

    /**
     * Wrapper class to encapsulate the state required to gracefully find both the maximum
     * total edge weight traverse-able along with the nodes traversed to get it.
     */
    private static class StatefulWeightedPathFinder {
        private Map<Node, Map<Node, Integer>> edgeWeights;
        private List<String> highestPathNodes;
        private int highestPathWeight;

        public WeightedPath find(Node node, Map<Node, Map<Node, Integer>> edgeWeights) {
            reset(edgeWeights);
            findMaxWeightedPath(node, 0, new ArrayList<>());
            return new WeightedPath(highestPathWeight, highestPathNodes);
        }

        private void findMaxWeightedPath(Node node, int runningMax, List<String> path) {
            if (node == null) {
                if (runningMax > highestPathWeight) {
                    this.highestPathWeight = runningMax;
                    this.highestPathNodes = new ArrayList<>(path);
                } else if (runningMax == highestPathWeight && path.size() > highestPathNodes.size()) {
                    // Update our node paths if we encounter a path with the same weight but more
                    // nodes (this happens when an edge has a weight of zero)
                    this.highestPathNodes = new ArrayList<>(path);
                }

                return;
            }

            path.add(node.value);
            findMaxWeightedPath(node.left, runningMax + getEdgeCost(node, node.left), path);
            findMaxWeightedPath(node.right, runningMax + getEdgeCost(node, node.right), path);
            path.remove(path.size() - 1);
        }

        private int getEdgeCost(Node from, Node to) {
            if (!edgeWeights.containsKey(from)) return 0;
            return edgeWeights.get(from).getOrDefault(to, 0);
        }

        private void reset(Map<Node, Map<Node, Integer>> edgeWeights) {
            this.highestPathWeight = Integer.MIN_VALUE;
            this.highestPathNodes = null;
            this.edgeWeights = edgeWeights;
        }

    }

    public static class WeightedPath {
        int weight;
        List<String> path;

        WeightedPath(int weight, List<String> path) {
            this.weight = weight;
            this.path = path;
        }
    }

    protected static class Node {
        Node left, right;
        String value;

        Node(String value) {
            this.value = value;
        }
        public int hashCode() {
            return Objects.hash(left, right, value);
        }
    }
}
