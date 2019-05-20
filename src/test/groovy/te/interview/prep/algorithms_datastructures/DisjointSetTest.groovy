package te.interview.prep.algorithms_datastructures

import spock.lang.Specification
import spock.lang.Subject

class DisjointSetTest extends Specification {

    @Subject
    DisjointSet<Integer> set = new DisjointSet<>([0, 1, 2, 3, 4])

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

    def "can convert the set to a list"() {
        expect:
            set.toList() == [0, 1, 2, 3, 4]
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
            set.findSet(0) == null
            set.findSet(2) == null
            set.findSet(4) == null
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
            set.findSet(99999) == null
    }

}
