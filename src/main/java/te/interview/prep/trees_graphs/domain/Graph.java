package te.interview.prep.trees_graphs.domain;

import java.util.List;

public class Graph {
    public GraphNode[] nodes;

    public Graph(GraphNode... nodes) {
        this.nodes = nodes;
    }

    public Graph(List<GraphNode> nodes) {
        this.nodes = nodes.toArray(new GraphNode[nodes.size()]);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Root has " + nodes.length + " children.\n");

        for (GraphNode node : nodes) {
            output.append("Child ")
                    .append(node.getName())
                    .append(":\n")
                    .append(node.toString())
                    .append("\n");
        }

        return output.toString();
    }
}
