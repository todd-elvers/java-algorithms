package te.interview.prep.trees_graphs;

import java.util.LinkedList;

import te.interview.prep.trees_graphs.domain.Graph;
import te.interview.prep.trees_graphs.domain.GraphNode;

public class GraphBreadthFirstSearchPrinter {

    // Prints the order in which nodes were visited
    String search(Graph graph) {
        StringBuilder visitOrder = new StringBuilder();
        LinkedList<GraphNode> nodesToVisit = new LinkedList<>();

        for (GraphNode graphNode : graph.nodes) {
            graphNode.setVisited(true);
            nodesToVisit.add(graphNode);
        }

        while (!nodesToVisit.isEmpty()) {
            GraphNode node = nodesToVisit.remove();

            visitOrder
                    .append(node.getName())
                    .append(",");

            for (GraphNode nextNode : node.getChildren()) {
                if (!nextNode.isVisited()) {
                    nextNode.setVisited(true);
                    nodesToVisit.add(nextNode);
                }
            }
        }

        return visitOrder.toString();
    }

}
