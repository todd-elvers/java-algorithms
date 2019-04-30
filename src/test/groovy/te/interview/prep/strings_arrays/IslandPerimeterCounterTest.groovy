package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.strings_arrays.IslandPerimeterCounter

class IslandPerimeterCounterTest extends Specification {

    @Subject
    IslandPerimeterCounter islandPerimeterCounter = []

    def "can correctly count the perimeter of an island"() {
        given:
            int[][] grid = [
                    [0,1,0,0],
                    [1,1,1,0],
                    [0,1,0,0],
                    [1,1,0,0]
            ]

        expect:
            islandPerimeterCounter.countPerimeter(grid) == 16
    }

}
