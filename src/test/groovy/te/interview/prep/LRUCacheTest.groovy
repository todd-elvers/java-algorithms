package te.interview.prep

import spock.lang.Specification
import spock.lang.Subject

class LRUCacheTest extends Specification {

    @Subject
    LRUCache cache

    def "can keep a cache that discards the least recently used elements first"() {
        given:
            cache = [10]

        when:
            cache.put(10, 13)
            cache.put(3, 17)
            cache.put(6, 11)
            cache.put(10, 5)
            cache.put(9, 10)

        then:
            cache.get(13) == -1

        when:
            cache.put(2, 19)

        then:
            cache.get(2) == 19
            cache.get(3) == 17

        when:
            cache.put(5, 25)

        then:
            cache.get(8) == -1

        when:
            cache.put(9, 22)
            cache.put(5, 5)
            cache.put(1, 30)

        then:
            cache.get(11) == -1

        when:
            cache.put(9, 12)

        then:
            cache.get(7) == -1
            cache.get(5) == 5
            cache.get(8) == -1
            cache.get(9) == 12

        when:
            cache.put(4, 30)
            cache.put(9, 3)

        then:
            cache.get(9) == 3
            cache.get(10) == 5
            cache.get(10) == 5

        when:
            cache.put(6, 14)
            cache.put(3, 1)

        then:
            cache.get(3) == 1

        when:
            cache.put(10, 11)

        then:
            cache.get(8) == -1

        when:
            cache.put(2, 14)

        then:
            cache.get(1) == 30
            cache.get(5) == 5
            cache.get(4) == 30

        when:
            cache.put(11, 4)
            cache.put(12, 24)
            cache.put(5, 18)

        then:
            cache.get(13) == -1

        when:
            cache.put(7, 23)

        then:
            cache.get(8) == -1
            cache.get(12) == 24

        when:
            cache.put(3, 27)
            cache.put(2, 12)

        then:
            cache.get(5) == 18

        when:
            cache.put(2, 9)
            cache.put(13, 4)
            cache.put(8, 18)
            cache.put(1, 7)

        then:
            cache.get(6) == -1

        when:
            cache.put(9, 29)
            cache.put(8, 21)

        then:
            cache.get(5) == 18

        when:
            cache.put(6, 30)
            cache.put(1, 12)

        then:
            cache.get(10) == -1

        when:
            cache.put(4, 15)
            cache.put(7, 22)
            cache.put(11, 26)
            cache.put(8, 17)
            cache.put(9, 29)

        then:
            cache.get(5) == 18

        when:
            cache.put(3, 4)
            cache.put(11, 30)

        then:
            cache.get(12) == -1

        when:
            cache.put(4, 29)

        then:
            cache.get(3) == 4
            cache.get(9) == 29
            cache.get(6) == 30

        when:
            cache.put(3, 4)

        then:
            cache.get(1) == 12
            cache.get(10) == -1

        when:
            cache.put(3, 29)
            cache.put(10, 28)
            cache.put(1, 20)
            cache.put(11, 13)

        then:
            cache.get(3) == 29

        when:
            cache.put(3, 12)
            cache.put(3, 8)
            cache.put(10, 9)
            cache.put(3, 26)

        then:
            cache.get(8) == 17
            cache.get(7) == 22
            cache.get(5) == 18

        when:
            cache.put(13, 17)
            cache.put(2, 27)
            cache.put(11, 15)

        then:
            cache.get(12) == -1

        when:
            cache.put(9, 19)
            cache.put(2, 15)
            cache.put(3, 16)

        then:
            cache.get(1) == 20

        when:
            cache.put(12, 17)
            cache.put(9, 1)
            cache.put(6, 19)

        then:
            cache.get(4) == -1
            cache.get(5) == 18
            cache.get(5) == 18

        when:
            cache.put(8, 1)
            cache.put(11, 7)
            cache.put(5, 2)
            cache.put(9, 28)

        then:
            cache.get(1) == 20

        and:
            cache.put(2, 2)
            cache.put(7, 4)
            cache.put(4, 22)
            cache.put(7, 24)
            cache.put(9, 26)
            cache.put(13, 28)
            cache.put(11, 26)
    }

    def "can handle a cache of size 1"() {
        given:
            cache = [1]

        when:
            cache.put(1, 1)
            cache.put(2, 2)

        then:
            cache.get(2) == 2
            cache.get(1) == -1
    }
}
