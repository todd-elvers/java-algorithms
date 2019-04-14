package te.interview.prep.strings_arrays.backtracking

import spock.lang.Specification
import te.interview.prep.strings_arrays.backtracking.PermutationGenerator

class PermutationGeneratorTest extends Specification {

    PermutationGenerator permutationGenerator = []

    def "can generate all permutations from unique set of integers"() {
        when:
            List<List<Integer>> permutations = permutationGenerator.generate([1, 2, 3] as int[])

        then:
            permutations?.size() == 6
            [1, 2, 3] in permutations
            [1, 3, 2] in permutations
            [2, 1, 3] in permutations
            [2, 3, 1] in permutations
            [3, 1, 2] in permutations
            [3, 2, 1] in permutations
    }

}
