package te.interview.prep.strings_arrays.backtracking

import spock.lang.Specification
import te.interview.prep.strings_arrays.backtracking.PowersetGenerator

class PowersetGeneratorTest extends Specification {

    PowersetGenerator powersetGenerator = []

    def "can generate a powerset for a distinct set of integers"() {
        given:
            int[] nums = [1, 2, 3] as int[]

        when:
            List<List<Integer>> powerset = powersetGenerator.generate(nums)

        then:
            powerset?.size() == 8

        and:
            []          in powerset
            [1]         in powerset
            [2]         in powerset
            [3]         in powerset
            [1, 2]      in powerset
            [1, 3]      in powerset
            [2, 3]      in powerset
            [1, 2, 3]   in powerset
    }

}
