package te.interview.prep.trees_graphs

@SuppressWarnings("GroovyPointlessBoolean")
class CousinDeterminerTest extends TreeTest {

    CousinDeterminer cousinDeterminer = []

    def "can determine if two nodes of a binary tree are cousins"() {
        expect:
            cousinDeterminer.isCousins(root, x, y) == isCousins

        where:
            root                                      | x | y || isCousins
            generateTree([1, 2, 3, 4])                | 4 | 3 || false
            generateTree([1, 2, 3, null, 4, null, 5]) | 5 | 4 || true
            generateTree([1, 2, 3, null, 4])          | 2 | 3 || false
            null                                      | 2 | 3 || false
            generateTree([1, 2, 3, null, 4, null, 5]) | 1 | 2 || false
            generateTree([1, 2, 3, null, 4, null, 5]) | 2 | 1 || false

    }

}
