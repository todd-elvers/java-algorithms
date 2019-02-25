package te.interview.prep.trees_graphs


import te.interview.prep.trees_graphs.domain.TreeNode

class LinkedListPerLevelGeneratorTest extends TreeTest {

    LinkedListPerLevelGenerator linkedListPerLevelGenerator = []

    def "creates a LinkedList for every level in the binary tree"() {
        given:
            def level1 = new LinkedList<TreeNode>()
            level1.add(new TreeNode(4))

        and:
            def level2 = new LinkedList<TreeNode>()
            level2.add(new TreeNode(2))
            level2.add(new TreeNode(5))

        and:
            def level3 = new LinkedList<TreeNode>()
            level3.add(new TreeNode(1))
            level3.add(new TreeNode(7))
            level3.add(new TreeNode(3))
            level3.add(new TreeNode(6))

        and:
            List<LinkedList<TreeNode>> expected = [
                    level1,
                    level2,
                    level3
            ]

        when:
            List<LinkedList<TreeNode>> actual = linkedListPerLevelGenerator.generateUsingDFS(root)

        then:
            actualMatchesExpected(actual, expected)

        when:
            actual = linkedListPerLevelGenerator.generateUsingBFS(root)

        then:
            actualMatchesExpected(actual, expected)
    }

    private static void actualMatchesExpected(
            List<LinkedList<TreeNode>> actual,
            List<LinkedList<TreeNode>> expected
    ) {
        assert actual.size() == expected.size()
        assert actual[0]*.data == expected[0]*.data
        assert actual[1]*.data == expected[1]*.data
        assert actual[2]*.data == expected[2]*.data
    }

}
