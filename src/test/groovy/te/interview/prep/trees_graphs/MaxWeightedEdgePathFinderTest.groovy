package te.interview.prep.trees_graphs

import spock.lang.Specification
import spock.lang.Subject

class MaxWeightedEdgePathFinderTest extends Specification {

    @Subject
    MaxWeightedEdgePathFinder maxWeightedEdgePathFinder = []

    def "can find max weighted path given a binary tree and map of edge costs"() {
        given: 'the following nodes'
            MaxWeightedEdgePathFinder.Node a = ["A"]
            MaxWeightedEdgePathFinder.Node b = ["B"]
            MaxWeightedEdgePathFinder.Node c = ["C"]
            MaxWeightedEdgePathFinder.Node d = ["D"]
            MaxWeightedEdgePathFinder.Node e = ["E"]
            MaxWeightedEdgePathFinder.Node f = ["F"]

        and: 'the following edges'
            a.left = b
            a.right = c
            c.left = d
            c.right = e
            d.left = f

        and: 'the following edge weights'
            Map<MaxWeightedEdgePathFinder.Node, Map<MaxWeightedEdgePathFinder.Node, Integer>> edgeWeights = [
                    (a): [(b): 10, (c): 2],
                    (c): [(e): 5, (d): 9],
                    (d): [(f): 0]
            ]

        when:
            def maxPath = maxWeightedEdgePathFinder.findHighestWeightedPath(a, edgeWeights)
        
        then:
            maxPath.weight == 11
            maxPath.path == ["A", "C", "D", "F"]
    }

}
