package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class MinimumCostHousePaintFinderTest extends Specification {

    @Subject
    MinimumCostHousePaintFinder minimumCostHousePaintFinder = []

    def "can find minimum cost to paint all houses"(int[][] costs, int minCost) {
        expect:
            minimumCostHousePaintFinder.find(costs) == minCost

        where:
            costs                                   || minCost
            null                                    || 0
            []                                      || 0
            [[17, 2, 17], [16, 16, 5], [14, 3, 19]] || 10
            [[17, 2, 3], [1, 2, 3], [1, 10, 20]]    || 6
    }

}
