package te.interview.prep.strings_arrays.backtracking

import spock.lang.Specification

class UniqueCombinationSumFinderTest extends Specification {

    UniqueCombinationSumFinder uniqueCombinationSumFinder = []

    def "can find all combinations that sum to a target value by only using each input integer once"() {
        when:
            def actualResults = uniqueCombinationSumFinder.findAll(candidates as int[], target)

        then:
            actualResults.size() == expectedResults.size()

        and:
            expectedResults.each {
                assert it in actualResults
            }

        where:
            candidates             | target || expectedResults
            [10, 1, 2, 7, 6, 1, 5] | 8      || [[1, 7], [1, 2, 5], [2, 6], [1, 1, 6]]
            [2, 5, 2, 1, 2]        | 5      || [[1, 2, 2], [5]]
    }

}
