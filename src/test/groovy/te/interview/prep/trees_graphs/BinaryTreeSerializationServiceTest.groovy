package te.interview.prep.trees_graphs


import spock.lang.Subject
import te.interview.prep.trees_graphs.domain.TreeNode

class BinaryTreeSerializationServiceTest extends TreeTest {

    @Subject
    BinaryTreeSerializationService service = []

    def "can serialize binary tree to string"() {
        given:
            TreeNode tree = generateTree([4, 8, 1, null, 2, null, null, 7, null, null, null])

        expect:
            service.serialize(tree) == "4,8,1,null,2,null,null,7,null,null,null"
    }

    def "can serialize & deserialize binary trees to/from a string"() {
        expect:
            service.deserialize(service.serialize(deserialized)) == deserialized

        where:
            deserialized << [
                    generateTree([1, 2, 3, null, null, 4, 5]),
                    generateTree([1,2])
            ]
    }

}
