package te.interview.prep.strings_arrays

import spock.lang.Specification

class CombinationSumFinderTest extends Specification {

    CombinationSumFinder combinationSumFinder = []

    def "can find all combinations that sum to a target value given a set of unique integers"() {
        when:
            def actualResults = combinationSumFinder.findAll(candidates as int[], targetValue)

        then: 'we got the correct number of results'
            actualResults.size() == expectedResults.size()

        and: 'each result is the expected result'
            expectedResults.each {
                assert it in actualResults
            }

        where:
            candidates   | targetValue || expectedResults
            [2, 3, 6, 7] | 7           || [[7], [2, 2, 3]]
            [2, 3, 5]    | 8           || [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
    }

}
