package te.interview.prep.trees_graphs

class TreeBreadthFirstSearchPrinterTest extends TreeTest {

    TreeBreadthFirstSearchPrinter breadthFirstSearch = []

    def "can print nodes in BFS order"() {
        expect:
            breadthFirstSearch.search(binarySearchTree) == "4,2,6,1,3,5,7,"
    }

}
