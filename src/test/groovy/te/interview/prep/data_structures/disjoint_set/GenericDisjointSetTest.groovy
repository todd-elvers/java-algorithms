package te.interview.prep.data_structures.disjoint_set

import spock.lang.Specification
import spock.lang.Subject

class GenericDisjointSetTest extends Specification {

    @Subject
    GenericDisjointSet<Integer> set = [[0, 1, 2, 3, 4]]

    def "can determine if two values are disjoint or not"() {
        when: 'we put 0 and 2 in the same set'
            set.union(0, 2)

        and: 'put 4 in that same set'
            set.union(4, 2)

        and: 'put 3 and 1 in a set of their own'
            set.union(3, 1)

        then: '4, 2, and 0 all belong to the same set'
            set.isSameSet(0, 2)
            set.isSameSet(4, 2)
            set.isSameSet(4, 0)

            set.isSameSet(2, 0)
            set.isSameSet(2, 4)
            set.isSameSet(0, 4)

            set.isSameSet(2, 2)
            set.isSameSet(4, 4)
            set.isSameSet(0, 0)

        and: '3 and 1 all belong to the same set'
            set.isSameSet(3, 1)
            set.isSameSet(1, 3)

            set.isSameSet(1, 1)
            set.isSameSet(3, 3)

        and: '3 and [4, 2, 0] are disjoint'
            set.isDisjoint(3, 4)
            set.isDisjoint(3, 2)
            set.isDisjoint(3, 0)

        and: '1 and [4, 2, 0] are disjoint'
            set.isDisjoint(1, 4)
            set.isDisjoint(1, 2)
            set.isDisjoint(1, 0)
    }

    def "nonexistent values are disjoint"() {
        expect:
            set.isDisjoint(null, null)
    }

    def "can remove all elements from a set"() {
        when: 'we put 0 and 2 in the same set'
            set.union(0, 2)

        and: 'put 4 in that same set'
            set.union(4, 2)

        and: 'put 3 and 1 in a set of their own'
            set.union(3, 1)

        and: 'remove everything in the set that belongs to 2'
            set.removeSet(2)

        then: '3 and 1 are still in their set'
            set.isSameSet(3, 1)

        and: '0, 2, and 4 no longer belong to a set'
            set.find(0) == null
            set.find(2) == null
            set.find(4) == null
    }

    def "trying to remove or union nodes that don't exist does nothing"() {
        when:
            set.removeSet(99999)
            set.union(99999, 2)
            set.union(2, 99999)
            set.union(null, null)

        then:
            noExceptionThrown()
    }

    def "trying to find nodes that don't exist returns null"() {
        expect:
            set.find(99999) == null
    }

}
