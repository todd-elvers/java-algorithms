package te.interview.prep.trees_graphs


import te.interview.prep.trees_graphs.domain.TreeNode

class LinkedListPerLevelGeneratorTest extends TreeTest {

    LinkedListPerLevelGenerator linkedListPerLevelGenerator = []

    def "creates a LinkedList for every level in the binary tree"() {
        given:
            LinkedList<TreeNode> level1 = [
                    new TreeNode(4)
            ]

        and:
            LinkedList<TreeNode> level2 = [
                    new TreeNode(2),
                    new TreeNode(6)
            ]

        and:
            LinkedList<TreeNode> level3 = [
                    new TreeNode(1),
                    new TreeNode(3),
                    new TreeNode(5),
                    new TreeNode(7)
            ]

        and:
            List<LinkedList<TreeNode>> expected = [
                    level1,
                    level2,
                    level3
            ]

        when:
            List<LinkedList<TreeNode>> actual = linkedListPerLevelGenerator.generateUsingBFS(binarySearchTree)

        then:
            actual == expected

        when:
            actual = linkedListPerLevelGenerator.generateUsingDFS(binarySearchTree)

        then:
            actual == expected
    }

}
