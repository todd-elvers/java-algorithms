package te.interview.prep.algorithms

import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.algorithms.domain.Graph

class TopologicalSortTest extends Specification {

    @Subject
    TopologicalSort algorithm = []

    def "can topologically sort unweighted DAG"() {
        given: 'a graph and a bunch of vertices'
            Graph g = []
            def v1 = new Graph.Vertex('A')
            def v2 = new Graph.Vertex('B')
            def v3 = new Graph.Vertex('C')
            def v4 = new Graph.Vertex('D')
            def v5 = new Graph.Vertex('E')
            def v6 = new Graph.Vertex('F')
            def v7 = new Graph.Vertex('G')
            def v8 = new Graph.Vertex('H')
            def v9 = new Graph.Vertex('I')
            g.vertices.addAll([v9, v1, v8, v2, v7, v3, v6, v4, v5])

        and: 'B -> [C, E]'
            v2.vertices = [v3, v5]

        and: 'D -> F'
            v4.vertices = [v6]

        and: 'E -> F'
            v5.vertices = [v6]

        and: 'F -> [G, I]'
            v6.vertices = [v7, v9]

        and: 'I -> H'
            v9.vertices = [v8]

        expect:
            algorithm.sort(g)*.name == ['A', 'B', 'D', 'C', 'E', 'F', 'G', 'I', 'H']
    }

    def "can find the shortest-path in a weighted DAG"() {
        given: 'a graph and a bunch of vertices'
            Graph g = []
            def v1 = new Graph.Vertex('A')
            def v2 = new Graph.Vertex('B')
            def v3 = new Graph.Vertex('C')
            def v4 = new Graph.Vertex('D')
            def v5 = new Graph.Vertex('E')
            def v6 = new Graph.Vertex('F')
            def v7 = new Graph.Vertex('G')
            def v8 = new Graph.Vertex('H')
            def v9 = new Graph.Vertex('I')
            g.vertices.addAll([v9, v1, v8, v2, v7, v3, v6, v4, v5])

        and: 'B -> [C(15), E(2)]'
            v2.vertices = [v3, v5]
            v2.edgeWeights[v3] = 15
            v2.edgeWeights[v5] = 2

        and: 'C -> I(15)'
            v3.vertices = [v8]
            v3.edgeWeights[v8] = 15

        and: 'D -> F(1)'
            v4.vertices = [v6]
            v4.edgeWeights[v6] = 1

        and: 'E -> F(2)'
            v5.vertices = [v6]
            v5.edgeWeights[v6] = 2

        and: 'F -> [G(1), I(3)]'
            v6.vertices = [v7, v9]
            v6.edgeWeights[v7] = 1
            v6.edgeWeights[v9] = 3

        and: 'I -> H(1)'
            v9.vertices = [v8]
            v9.edgeWeights[v8] = 1

        when:
            def vertexToShortestPathCost = algorithm.findShortestPathsToAllOtherVertices(g, v2)

        then: 'the shortest path to ourselves is 0'
            vertexToShortestPathCost[v2] == 0

        and: 'A and D are inaccessible from B, so their distance is infinite'
            vertexToShortestPathCost[v1] == Integer.MAX_VALUE
            vertexToShortestPathCost[v4] == Integer.MAX_VALUE

        and: 'the shortest paths to the remaining elements is correct'
            vertexToShortestPathCost[v3] == 15
            vertexToShortestPathCost[v5] == 2
            vertexToShortestPathCost[v6] == 4
            vertexToShortestPathCost[v7] == 5
            vertexToShortestPathCost[v8] == 8
            vertexToShortestPathCost[v9] == 7
    }
}
