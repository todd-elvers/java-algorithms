package te.interview.prep.trees_graphs

class TreeTraversingPrinterTest extends TreeTest {

    TreeTraversingPrinter treeTraversingPrinter = []

    def "in-order traversal prints the correct traversal order"() {
        expect:
            treeTraversingPrinter.inOrderTraversal(root) == "1234567"
    }

    def "pre-order traversal prints the correct traversal order"() {
        expect:
            treeTraversingPrinter.preOrderTraversal(root) == "4213657"
    }

    def "post-order traversal prints the correct traversal order"() {
        expect:
            treeTraversingPrinter.postOrderTraversal(root) == "1325764"
    }

}
