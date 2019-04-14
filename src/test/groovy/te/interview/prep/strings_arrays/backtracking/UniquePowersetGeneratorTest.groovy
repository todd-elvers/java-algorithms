package te.interview.prep.strings_arrays.backtracking

import spock.lang.Specification
import te.interview.prep.strings_arrays.backtracking.UniquePowersetGenerator

class UniquePowersetGeneratorTest extends Specification {

    UniquePowersetGenerator uniquePowersetGenerator = []

    def "can generate a unique powerset for a set of integers containing duplicates"() {
        given:
            int[] nums = [2, 1, 2] as int[]

        when:
            List<List<Integer>> powerset = uniquePowersetGenerator.generate(nums)

        then:
            powerset?.size() == 6

        and:
            []          in powerset
            [1]         in powerset
            [2]         in powerset
            [1, 2]      in powerset
            [2, 2]      in powerset
            [1, 2, 2]   in powerset
    }

}
