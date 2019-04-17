package te.interview.prep

import spock.lang.Specification
import spock.lang.Subject

class IslandCounterTest extends Specification {

    @Subject
    IslandCounter islandCounter = []

    char[][] grid

    def "can determine the number of islands present in a grid"() {
        when:
            grid = [
                    ["1", "0", "1", "1", "1"] as char[],
                    ["1", "0", "1", "0", "1"] as char[],
                    ["1", "1", "1", "0", "1"] as char[],
            ]

        then:
            islandCounter.count(grid) == 1

        when:
            grid = [
                    ["1", "1", "0", "0", "0"] as char[],
                    ["1", "1", "0", "0", "0"] as char[],
                    ["0", "0", "1", "0", "0"] as char[],
                    ["0", "0", "0", "1", "1"] as char[],
            ]

        then:
            islandCounter.count(grid) == 3

        when:
            grid = [
                    ["1", "0", "1", "1", "0", "1", "1"] as char[],
            ]

        then:
            islandCounter.count(grid) == 3
    }

}
