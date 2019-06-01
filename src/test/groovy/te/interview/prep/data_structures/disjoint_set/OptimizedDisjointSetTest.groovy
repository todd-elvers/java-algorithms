package te.interview.prep.data_structures.disjoint_set

import spock.lang.Specification
import spock.lang.Subject

class OptimizedDisjointSetTest extends Specification {

    @Subject
    OptimizedDisjointSet set = [[0, 1, 2, 3, 4] as int[]]

    def "can determine if two values are disjoint or not"() {
        when: 'we put 0 and 2 in the same set'
            set.union(0, 2)

        and: 'put 4 in that same set'
            set.union(4, 2)

        and: 'put 3 and 1 in a set of their own'
            set.union(3, 1)

        then: '4, 2, and 0 all belong to the same set'
            isSameSet(0, 2)
            isSameSet(4, 2)
            isSameSet(4, 0)

            isSameSet(2, 0)
            isSameSet(2, 4)
            isSameSet(0, 4)

            isSameSet(2, 2)
            isSameSet(4, 4)
            isSameSet(0, 0)

        and: '3 and 1 all belong to the same set'
            isSameSet(3, 1)
            isSameSet(1, 3)

            isSameSet(1, 1)
            isSameSet(3, 3)

        and: '3 and [4, 2, 0] are disjoint'
            isDisjoint(3, 4)
            isDisjoint(3, 2)
            isDisjoint(3, 0)

        and: '1 and [4, 2, 0] are disjoint'
            isDisjoint(1, 4)
            isDisjoint(1, 2)
            isDisjoint(1, 0)
    }

    def "can remove all elements from a set"() {
        when: 'we put 0 and 2 in the same set'
            set.union(0, 2)

        and: 'put 4 in that same set'
            set.union(4, 2)

        and: 'put 3 and 1 in a set of their own'
            set.union(3, 1)

        and: 'remove everything in the set that belongs to 2'
            set.remove(2)

        then: '3 and 1 are still in their set'
            set.find(3) == set.find(1)

        and: '0, 2, and 4 no longer belong to a set'
            set.find(0) == -1
            set.find(2) == -1
            set.find(4) == -1
    }

    def "trying to remove or union nodes that don't exist does nothing"() {
        when:
            set.remove(99999)
            set.union(99999, 2)
            set.union(2, 99999)

        then:
            noExceptionThrown()
    }

    def "trying to find nodes that don't exist returns null"() {
        expect:
            set.find(99999) == -1
    }

    private boolean isSameSet(int x, int y) {
        int setRepX = set.find(x), setRepY = set.find(y)
        return (setRepX != -1 && setRepY != -1) && setRepX == setRepY
    }

    private boolean isDisjoint(Integer x, Integer y) {
        int setRepX = set.find(x), setRepY = set.find(y)
        return (setRepX == -1 || setRepY == -1) || setRepX != setRepY
    }
}
