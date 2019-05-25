package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class MinimumCostHiringFinderTest extends Specification {

    @Subject
    MinimumCostHiringFinder minimumCostHiringFinder = []

    def "can find the minimum cost to create a paid group of size k"(int[] quality, int[] wage, int k, double cost) {
        expect:
            minimumCostHiringFinder.ofSizeK(quality, wage, k).round(5) == cost.round(5)

        where:
            quality           | wage            | k || cost
            [3, 1, 10, 10, 1] | [4, 8, 2, 2, 7] | 3 || 30.66667
            [10, 20, 5]       | [70, 50, 30]    | 2 || 105
    }

}
