package te.interview.prep.trees_graphs

class GraphDepthFirstSearchPrinterTest extends DirectedGraphTest {

    GraphDepthFirstSearchPrinter depthFirstSearch = []

    def "can print nodes in DFS order"() {
        expect:
            depthFirstSearch.search(graph) == "A,B,D,E,C,X,Y,Z,L,M,N,"
    }

}
