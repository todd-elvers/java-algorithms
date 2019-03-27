package te.interview.prep.trees_graphs

import te.interview.prep.trees_graphs.domain.TreeNode

class BinarySearchTreeInverterTest extends TreeTest {

    BinarySearchTreeInverter bstInverter = []

    def "can invert a BST"() {
        given:
            TreeNode expectedBST = generateTree([4,6,2,7,5,3,1])
        
        when:
            TreeNode actualBST = bstInverter.invert(binarySearchTree)

        then:
            actualBST.deepEquals(expectedBST)
    }

}
