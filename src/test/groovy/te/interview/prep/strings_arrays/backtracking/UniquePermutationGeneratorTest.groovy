package te.interview.prep.strings_arrays.backtracking

import spock.lang.Specification
import te.interview.prep.strings_arrays.backtracking.UniquePermutationGenerator

class UniquePermutationGeneratorTest extends Specification {

    UniquePermutationGenerator uniquePermutationGenerator = []

    def "can generate all unique permutations for a set of integers containing duplicates"() {
        when:
            List<List<Integer>> permutations = uniquePermutationGenerator.generate([1, 2, 1] as int[])

        then:
            permutations?.size() == 3
            [1, 1, 2] in permutations
            [1, 2, 1] in permutations
            [2, 1, 1] in permutations
    }

}
