package te.interview.prep.strings_arrays.backtracking

import spock.lang.Specification
import spock.lang.Subject

class ParenthesesCombinationFinderTest extends Specification {

    @Subject
    ParenthesesCombinationFinder parenthesesCombinationFinder = []

    def "can determine all valid combinations of parentheses"() {
        when:
            List<String> results = parenthesesCombinationFinder.findCombinations(3)

        then:
            results.size() == 5

        and:
            results.contains("((()))")
            results.contains("(()())")
            results.contains("(())()")
            results.contains("()(())")
            results.contains("()()()")
    }
}
