package te.interview.prep.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import te.interview.prep.algorithms.domain.Graph;

public class TopologicalSort {

    public List<Graph.Vertex> sort(Graph g) {
        // Count the number of incoming edges to each vertex
        Map<Graph.Vertex, Integer> inboundEdgeCounts = new HashMap<>();
        for (Graph.Vertex v : g.vertices) {
            inboundEdgeCounts.putIfAbsent(v, 0);
            for (Graph.Vertex u : v.vertices) {
                inboundEdgeCounts.put(u, inboundEdgeCounts.getOrDefault(u, 0) + 1);
            }
        }

        // Queue up all vertices with no incoming edges
        LinkedList<Graph.Vertex> queue = new LinkedList<>();
        for (Map.Entry<Graph.Vertex, Integer> entry : inboundEdgeCounts.entrySet()) {
            if (entry.getValue() == 0) {
                queue.addLast(entry.getKey());
            }
        }

        // Process all vertices with no inbound edges, decrementing the inbound edges of
        // all neighboring vertices and adding them to the queue if their inbound count is 0
        List<Graph.Vertex> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Graph.Vertex v = queue.removeFirst();
            for (Graph.Vertex u : v.vertices) {
                int newEdgeCount = inboundEdgeCounts.compute(u, (vertex, count) -> count - 1);
                if (newEdgeCount == 0) {
                    queue.addLast(u);
                }
            }

            result.add(v);
        }

        return result;
    }

    public Map<Graph.Vertex, Integer> findShortestPathsToAllOtherVertices(Graph g, Graph.Vertex source) {
        List<Graph.Vertex> sorted = sort(g);

        // Initialize distance to all nodes from source as infinity (except for source)
        Map<Graph.Vertex, Integer> distanceFromSource = new HashMap<>(sorted.size());
        for (Graph.Vertex v : sorted) distanceFromSource.put(v, Integer.MAX_VALUE);
        distanceFromSource.put(source, 0);

        for (Graph.Vertex v : sorted) {
            // All nodes prior to `source` will remain infinitely far away
            if (distanceFromSource.get(v) == Integer.MAX_VALUE) continue;

            for (Graph.Vertex x : v.vertices) {
                // Update our shortest path estimate if our previous source -> x
                // estimate is more expensive than our current source -> x estimate
                int pathCost = distanceFromSource.get(v) + v.edgeWeights.get(x);
                if (distanceFromSource.get(x) > pathCost) {
                    distanceFromSource.put(x, pathCost);
                }
            }
        }

        return distanceFromSource;
    }

}
