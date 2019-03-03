package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.Graph;
import te.interview.prep.trees_graphs.domain.GraphNode;

/**
 * TODO: Come back to me, didn't quite get it (base case caught me)
 */
public class GraphDepthFirstSearchPrinter {

    // Prints the order in which nodes were visited
    String search(Graph graph) {
        StringBuilder visitOrder = new StringBuilder();

        for (GraphNode node : graph.nodes) {
            search(node, visitOrder);
        }

        return visitOrder.toString();
    }

    private void search(GraphNode node, StringBuilder visitOrder) {
        if (node == null) return;

        visit(node, visitOrder);
        node.setVisited(true);

        for (GraphNode nextNode : node.getChildren()) {
            if (!nextNode.isVisited()) {
                search(nextNode, visitOrder);
            }
        }
    }

    private void visit(GraphNode node, StringBuilder sb) {
        sb.append(node.getName()).append(",");
    }
}
