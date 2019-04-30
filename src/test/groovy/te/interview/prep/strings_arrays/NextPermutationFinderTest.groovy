package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.strings_arrays.NextPermutationFinder

class NextPermutationFinderTest extends Specification {

    @Subject
    NextPermutationFinder nextPermutationFinder = []

    int[] nums

    def "can find next lexicographical permutation"() {
        when:
            nums = [1, 2, 3] as int[]
            nextPermutationFinder.findNext(nums)

        then:
            nums == [1, 3, 2] as int[]

        when:
            nums = [3, 2, 1] as int[]
            nextPermutationFinder.findNext(nums)

        then:
            nums == [1, 2, 3] as int[]

        when:
            nums = [1, 1, 5] as int[]
            nextPermutationFinder.findNext(nums)

        then:
            nums == [1, 5, 1] as int[]

        when:
            nums = [1, 3, 2] as int[]
            nextPermutationFinder.findNext(nums)

        then:
            nums == [2, 1, 3] as int[]

        when:
            nums = [1, 5, 1] as int[]
            nextPermutationFinder.findNext(nums)

        then:
            nums == [5, 1, 1] as int[]
    }

    def "can find index of first decreasing element from the right"() {
        expect:
            nextPermutationFinder.findFirstDecreasingElementInReverse([2, 1, 3] as int[]) == 1
            nextPermutationFinder.findFirstDecreasingElementInReverse([4, 7, 6] as int[]) == 0
            nextPermutationFinder.findFirstDecreasingElementInReverse([3, 2, 1] as int[]) == -1
    }

    def "can find index of first increasing element from the left"() {
        expect:
            nextPermutationFinder.findElementClosestInValueToFirstDecreasing([1, 5, 8, 4, 7, 6, 5, 3, 1] as int[], 3) == 6
            nextPermutationFinder.findElementClosestInValueToFirstDecreasing([1, 5, 1] as int[], 0) == 1
            nextPermutationFinder.findElementClosestInValueToFirstDecreasing([1, 5, 1] as int[], 1) == 1
    }

    def "can reverse an array from a given position using constant memory"() {
        when:
            nums = [1, 2, 3] as int[]
            nextPermutationFinder.reverse(nums, 0)

        then:
            nums == [3, 2, 1] as int[]

        when:
            nums = [1, 2, 3, 4] as int[]
            nextPermutationFinder.reverse(nums, 0)

        then:
            nums == [4, 3, 2, 1] as int[]

        when:
            nums = [1, 2, 3] as int[]
            nextPermutationFinder.reverse(nums, 1)

        then:
            nums == [1, 3, 2] as int[]
    }
}
