package te.interview.prep.trees_graphs

class GraphDepthFirstSearchPrinterTest extends DirectedGraphTest {

    GraphDepthFirstSearchPrinter depthFirstSearch = []

    def "can print nodes in DFS order"() {
        when:
            String visitOrder = depthFirstSearch.search(graph)

        then:
            visitOrder == "A,B,D,E,C,X,Y,Z,L,M,N,"
    }

}
