package te.interview.prep.trees_graphs

import spock.lang.Specification
import te.interview.prep.trees_graphs.domain.TreeNode

class BSTInputPermutationGeneratorTest extends Specification {

    BSTInputPermutationGenerator bstInputPermutationGenerator = []

    def "can generate permutations of potential input arrays to a BST"() {
        given:
            TreeNode n1 = [1]
            TreeNode n3 = [3]
            TreeNode n2 = [2, n1, n3]
            TreeNode n5 = [5]
            TreeNode n4 = [4, n2, n5]

        when:
            def results = bstInputPermutationGenerator.generate(n4)

        then:
            results?.size() == 8
            results.contains(linkedList(4, 2, 1, 3, 5))
            results.contains(linkedList(4, 2, 1, 5, 3))
            results.contains(linkedList(4, 2, 5, 1, 3))
            results.contains(linkedList(4, 5, 2, 1, 3))
            results.contains(linkedList(4, 2, 3, 1, 5))
            results.contains(linkedList(4, 2, 3, 5, 1))
            results.contains(linkedList(4, 2, 5, 3, 1))
            results.contains(linkedList(4, 5, 2, 3, 1))
    }

    private static LinkedList<Integer> linkedList(int ... integers) {
        LinkedList<Integer> linkedList = new LinkedList<>()
        integers.each { linkedList.add(it) }
        return linkedList
    }

}
