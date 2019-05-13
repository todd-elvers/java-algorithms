package te.interview.prep


import spock.lang.Specification
import spock.lang.Subject

class LRUCacheTest extends Specification {

    @Subject
    LRUCache cache

    def "can keep a cache that discards the least recently used elements first"() {
        given: 'a cache that can only hold 2 elements'
            cache = [2]

        when: 'we insert 1 & 2'
            cache.put(1, 1)
            cache.put(2, 2)  // TODO: Can we move this insert down to the next 'when'?

        then: 'we can find 1'
            cache.get(1) == 1

        when: 'we insert 3'
            cache.put(3, 3)

        then: 'we evicted 2'
            cache.get(2) == -1

        when: 'we insert 4'
            cache.put(4, 4)

        and: 'update our 4 to now be a 5, but with the same key'
            cache.put(4, 5)

        then: 'we evicted 1'
            cache.get(1) == -1

        expect: 'our cache to only contain 3 & 4 at this point'
            cache.get(3) == 3
            cache.get(4) == 5
    }

}
