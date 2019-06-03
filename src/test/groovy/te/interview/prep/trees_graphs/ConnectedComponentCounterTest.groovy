package te.interview.prep.trees_graphs

import spock.lang.Specification
import spock.lang.Subject

class ConnectedComponentCounterTest extends Specification {

    @Subject
    ConnectedComponentCounter connectedComponentCounter = []

    def "can count the number of connected components in an undirected graph"(int numNodes, int[][] edges, int result) {
        expect:
            connectedComponentCounter.count(numNodes, edges) == result

        where:
            numNodes | edges                            || result
            0        | [[0, 1], [1, 2], [3, 4]]         || 0
            5        | []                               || 5
            5        | [[0, 1], [1, 2], [3, 4]]         || 2
            5        | [[0, 1], [1, 2], [2, 3], [3, 4]] || 1
    }

}
