package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class SortedArrayMissingElementFinderTest extends Specification {

    @Subject
    SortedArrayMissingElementFinder.UsingBruteForce bruteForceApproach = []
    SortedArrayMissingElementFinder.UsingBinarySearch binarySearchApproach = []

    def "can find the k-th missing number in a sorted array"(int[] nums, int k, int missingNumber) {
        expect:
            bruteForceApproach.find(nums, k) == missingNumber
            binarySearchApproach.find(nums, k) == missingNumber

        where:
            nums          | k || missingNumber
            [1]           | 4 || 5
            [4, 7, 9, 10] | 1 || 5
            [4, 7, 9, 10] | 3 || 8
            [-3, 0, 3]    | 4 || 2
            [1, 2, 4]     | 3 || 6
    }

}
