package te.interview.prep.trees_graphs

import org.junit.Before
import spock.lang.Shared
import spock.lang.Specification
import te.interview.prep.trees_graphs.domain.Graph
import te.interview.prep.trees_graphs.domain.GraphNode

/**
 * Creates a graph with the following layout:
 *
 * A: B
 * B: D, C
 * D: E
 * E: C
 * C:
 * X: Y
 * Y: Z
 * Z:
 * L: M, N
 * M:
 * N:
 *
 */
abstract class DirectedGraphTest extends Specification {

    @Shared GraphNode c = ["C"]
    @Shared GraphNode e = ["E", c]
    @Shared GraphNode d = ["D", e]
    @Shared GraphNode b = ["B", d, c]
    @Shared GraphNode a = ["A", b]

    @Shared GraphNode z = ["Z"]
    @Shared GraphNode y = ["Y", z]
    @Shared GraphNode x = ["X", y]

    @Shared GraphNode m = ["M"]
    @Shared GraphNode n = ["N"]
    @Shared GraphNode l = ["L", m, n]

    @Shared Graph graph = new Graph(a, x, l)

    @Before
    void resetVisitedFlags() {
        [c,e,d,b,a,z,y,x,m,n,l]*.setVisited(false)
    }

}
