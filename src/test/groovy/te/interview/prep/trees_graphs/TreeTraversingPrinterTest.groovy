package te.interview.prep.trees_graphs

class TreeTraversingPrinterTest extends TreeTest {

    TreeTraversingPrinter treeTraversingPrinter = []

    def "in-order traversal prints the correct traversal order"() {
        expect:
            treeTraversingPrinter.inOrderTraversal(binarySearchTree) == "1234567"
    }

    def "pre-order traversal prints the correct traversal order"() {
        expect:
            treeTraversingPrinter.preOrderTraversal(binarySearchTree) == "4213657"
    }

    def "post-order traversal prints the correct traversal order"() {
        expect:
            treeTraversingPrinter.postOrderTraversal(binarySearchTree) == "1325764"
    }

}
