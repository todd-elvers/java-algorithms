package te.interview.prep.algorithms

import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.algorithms.domain.Graph

class TopologicalSortTest extends Specification {

    @Subject
    TopologicalSort algorithm = []

    def "can topologically sort unweighted DAG"() {
        given: 'a graph and a bunch of vertices'
            Graph graph = []
            def a = new Graph.Vertex('A')
            def b = new Graph.Vertex('B')
            def c = new Graph.Vertex('C')
            def d = new Graph.Vertex('D')
            def e = new Graph.Vertex('E')
            def f = new Graph.Vertex('F')
            def g = new Graph.Vertex('G')
            def h = new Graph.Vertex('H')
            def i = new Graph.Vertex('I')
            graph.vertices.addAll([i, a, h, b, g, c, f, d, e])

        and: 'B -> [C, E]'
            b.vertices = [c, e]

        and: 'D -> F'
            d.vertices = [f]

        and: 'E -> F'
            e.vertices = [f]

        and: 'F -> [G, I]'
            f.vertices = [g, i]

        and: 'I -> H'
            i.vertices = [h]

        expect:
            algorithm.sort(graph)*.name == ['A', 'B', 'D', 'C', 'E', 'F', 'G', 'I', 'H']
    }

    def "can find the shortest-path in a weighted DAG"() {
        given: 'a graph and a bunch of vertices'
            Graph graph = []
            def a = new Graph.Vertex('A')
            def b = new Graph.Vertex('B')
            def c = new Graph.Vertex('C')
            def d = new Graph.Vertex('D')
            def e = new Graph.Vertex('E')
            def f = new Graph.Vertex('F')
            def g = new Graph.Vertex('G')
            def h = new Graph.Vertex('H')
            def i = new Graph.Vertex('I')
            graph.vertices.addAll([i, a, h, b, g, c, f, d, e])

        and: 'B -> [C(15), E(2)]'
            b.vertices = [c, e]
            b.edgeWeights[c] = 15
            b.edgeWeights[e] = 2

        and: 'C -> I(15)'
            c.vertices = [h]
            c.edgeWeights[h] = 15

        and: 'D -> F(1)'
            d.vertices = [f]
            d.edgeWeights[f] = 1

        and: 'E -> F(2)'
            e.vertices = [f]
            e.edgeWeights[f] = 2

        and: 'F -> [G(1), I(3)]'
            f.vertices = [g, i]
            f.edgeWeights[g] = 1
            f.edgeWeights[i] = 3

        and: 'I -> H(1)'
            i.vertices = [h]
            i.edgeWeights[h] = 1

        when:
            def vertexToShortestPathCost = algorithm.findShortestPathsToAllOtherVertices(graph, b)

        then: 'the shortest path to ourselves is 0'
            vertexToShortestPathCost[b] == 0

        and: 'A and D are inaccessible from B, so their distance is infinite'
            vertexToShortestPathCost[a] == Integer.MAX_VALUE
            vertexToShortestPathCost[d] == Integer.MAX_VALUE

        and: 'the shortest paths to the remaining elements is correct'
            vertexToShortestPathCost[c] == 15
            vertexToShortestPathCost[e] == 2
            vertexToShortestPathCost[f] == 4
            vertexToShortestPathCost[g] == 5
            vertexToShortestPathCost[h] == 8
            vertexToShortestPathCost[i] == 7
    }
}
