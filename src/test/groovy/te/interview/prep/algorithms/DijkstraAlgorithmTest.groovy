package te.interview.prep.algorithms

import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.algorithms.domain.Graph

class DijkstraAlgorithmTest extends Specification {

    @Subject
    DijkstraAlgorithm algorithm = []

    def "can find shortest path using dijkstra's algorithm"() {
        given: 'vertices a through i'
            def a = new Graph.Vertex('A')
            def b = new Graph.Vertex('B')
            def c = new Graph.Vertex('C')
            def d = new Graph.Vertex('D')
            def e = new Graph.Vertex('E')
            def f = new Graph.Vertex('F')
            def g = new Graph.Vertex('G')
            def h = new Graph.Vertex('H')
            def i = new Graph.Vertex('I')

        and: 'in a graph'
            Graph graph = []
            graph.vertices.addAll([i, a, h, b, g, c, f, d, e])

        and: 'the edges of those vertices'
            addEdgesToVertex(a, [(b): 5, (c): 3, (e): 2])
            addEdgesToVertex(b, [(d): 2])
            addEdgesToVertex(c, [(b): 1, (d): 1])
            addEdgesToVertex(d, [(a): 1, (g): 2, (h): 1])
            addEdgesToVertex(e, [(a): 1, (h): 4, (i): 7])
            addEdgesToVertex(f, [(b): 3, (g): 1])
            addEdgesToVertex(g, [(c): 3, (i): 2])
            addEdgesToVertex(h, [(c): 2, (f): 2, (g): 2])
            addEdgesToVertex(i, [:])

        expect:
            algorithm.findShortestPath(graph, a, i) == ['A', 'C', 'D', 'G', 'I']
            algorithm.findShortestPath(graph, a, h) == ['A', 'C', 'D', 'H']
            algorithm.findShortestPath(graph, a, f) == ['A', 'C', 'D', 'H', 'F']
            algorithm.findShortestPath(graph, a, e) == ['A', 'E']
            algorithm.findShortestPath(graph, a, b) == ['A', 'C', 'B']
            algorithm.findShortestPath(graph, e, i) == ['E', 'I']
    }

    private static void addEdgesToVertex(Graph.Vertex vertex, Map<Graph.Vertex, Integer> edges) {
        edges.each { adjacentVertex, weight ->
            vertex.vertices.add(adjacentVertex)
            vertex.edgeWeights[adjacentVertex] = weight
        }
    }
}
