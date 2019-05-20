package te.interview.prep.sorting

import spock.lang.Specification
import spock.lang.Subject

class DisjointSetTest extends Specification {

    @Subject
    DisjointSet<Integer> set = new DisjointSet<>([0, 1, 2, 3, 4])

    def "can convert the set to a list"() {
        expect:
            set.toList() == [0, 1, 2, 3, 4]
    }

    def "can determine if two values are disjoint or not"() {
        when: 'we put 0 and 2 in the same set'
            set.union(0, 2)

        and: 'put 4 in that same set'
            set.union(4, 2)

        and: 'put 3 and 1 in a set of their own'
            set.union(3, 1)

        then: '4, 2, and 0 all belong to the same set'
            set.findSet(0) != null
            set.findSet(2) != null
            set.findSet(4) != null

            set.findSet(0) == set.findSet(2)
            set.findSet(4) == set.findSet(2)
            set.findSet(4) == set.findSet(0)

            set.findSet(2) == set.findSet(0)
            set.findSet(2) == set.findSet(4)
            set.findSet(0) == set.findSet(4)

            set.findSet(2) == set.findSet(2)
            set.findSet(4) == set.findSet(4)
            set.findSet(0) == set.findSet(0)

        and: '3 and 1 all belong to the same set'
            set.findSet(3) != null
            set.findSet(1) != null

            set.findSet(3) == set.findSet(1)
            set.findSet(1) == set.findSet(3)

            set.findSet(1) == set.findSet(1)
            set.findSet(3) == set.findSet(3)

        and: '3 and [4, 2, 0] are disjoint'
            set.findSet(3) != set.findSet(4)
            set.findSet(3) != set.findSet(2)
            set.findSet(3) != set.findSet(0)

        and: '1 and [4, 2, 0] are disjoint'
            set.findSet(1) != set.findSet(4)
            set.findSet(1) != set.findSet(2)
            set.findSet(1) != set.findSet(0)
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
            set.findSet(3) != null
            set.findSet(1) != null
            set.findSet(3) == set.findSet(1)

        and: '0, 2, and 4 no longer belong to a set'
            set.findSet(0) == null
            set.findSet(2) == null
            set.findSet(4) == null
    }

    def "trying to remove nodes that don't exist does nothing"() {
        when:
            set.removeSet(99999)

        then:
            noExceptionThrown()
    }

    def "trying to find nodes that don't exist returns null"() {
        expect:
            set.findSet(99999) == null
    }

}
