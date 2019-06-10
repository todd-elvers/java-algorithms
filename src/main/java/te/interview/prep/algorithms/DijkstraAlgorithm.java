package te.interview.prep.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import te.interview.prep.algorithms.domain.Graph;

public class DijkstraAlgorithm {

    public List<String> findShortestPath(Graph graph, Graph.Vertex src, Graph.Vertex dest) {
        Map<Graph.Vertex, Integer> distanceToSrc = initDistancesToSource(graph, src);
        Map<Graph.Vertex, Graph.Vertex> previous = new HashMap<>();

        PriorityQueue<Graph.Vertex> remaining = new PriorityQueue<>(Comparator.comparingInt(distanceToSrc::get));
        remaining.add(src);

        while(!remaining.isEmpty()) {
            Graph.Vertex v = remaining.poll();

            for(Graph.Vertex x : v.vertices) {
                // Update our shortest path if the cost of src -> v -> x
                // is cheaper than our existing cost of src -> x
                int newPath = distanceToSrc.get(v) + v.edgeWeights.get(x);
                if(distanceToSrc.get(x) > newPath) {
                    distanceToSrc.put(x, newPath);
                    previous.put(x, v);
                    remaining.add(x);
                }
            }
        }

        return reconstructShortestPath(previous, dest);
    }

    // All vertices are initialized to infinitely far away from the source (except source itself)
    private Map<Graph.Vertex, Integer> initDistancesToSource(Graph graph, Graph.Vertex src) {
        Map<Graph.Vertex, Integer> distanceToSource = new HashMap<>();
        for(Graph.Vertex v : graph.vertices) distanceToSource.put(v, Integer.MAX_VALUE);
        distanceToSource.put(src, 0);
        return distanceToSource;
    }

    // Walk back through previous from dest -> src to build shortest path
    private List<String> reconstructShortestPath(Map<Graph.Vertex, Graph.Vertex> previous, Graph.Vertex dest) {
        List<String> shortestPath = new ArrayList<>();
        Graph.Vertex current = dest;
        while(current != null) {
            shortestPath.add(current.name);
            current = previous.get(current);
        }

        Collections.reverse(shortestPath);

        return shortestPath;
    }

}
