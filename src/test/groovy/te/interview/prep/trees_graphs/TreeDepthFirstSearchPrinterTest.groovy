package te.interview.prep.trees_graphs

class TreeDepthFirstSearchPrinterTest extends TreeTest {

    TreeDepthFirstSearchPrinter depthFirstSearch = []

    def "can print nodes in DFS order"() {
        expect:
            depthFirstSearch.search(root) == "4,2,1,3,6,5,7,"
    }

}
