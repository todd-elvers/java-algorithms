package te.interview.prep.trees_graphs


import te.interview.prep.trees_graphs.domain.TreeNode

class MinimalHeightBinaryTreeBuilderTest extends TreeTest {

    MinimalHeightBinaryTreeBuilder binaryTreeBuilder = []

    def "given a sorted array of integers we build a BST with minimal height"() {
        given:
            int[] input = [1, 2, 3, 4, 5, 6, 7]

        when:
            TreeNode output = binaryTreeBuilder.build(input)

        then:
            isBinarySearchTree(output)
            findHeightOfTree(output) == 2
    }

    def "can handle an even number of numbers"() {
        given:
            int[] input = [1, 2, 3, 4, 5, 6, 7, 8]

        when:
            TreeNode output = binaryTreeBuilder.build(input)

        then:
            printTree(output)
            isBinarySearchTree(output)
            findHeightOfTree(output) == 3
    }
}
