package te.interview.prep.trees_graphs;

import java.util.LinkedList;

import te.interview.prep.trees_graphs.domain.GraphNode;

/**
 * 4.1
 */
public class DirectedGraphRouteFinder {

    // Simple BFS until we find a link from `src` to `dest`
    public boolean doesRouteExist(GraphNode src, GraphNode dest) {
        LinkedList<GraphNode> nodesToVisit = new LinkedList<>();
        src.setVisited(true);
        nodesToVisit.add(src);

        while (!nodesToVisit.isEmpty()) {
            GraphNode node = nodesToVisit.remove();

            for (GraphNode nextNode : node.getChildren()) {
                if (!nextNode.isVisited()) {
                    if (nextNode == dest) return true;

                    nextNode.setVisited(true);
                    nodesToVisit.add(nextNode);
                }
            }
        }

        return false;
    }

}
