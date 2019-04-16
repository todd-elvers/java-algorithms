package te.interview.prep.strings_arrays.backtracking

import spock.lang.Specification

class PalindromePartitionerTest extends Specification {

    PalindromePartitioner palindromePartitioner = []

    def "can generate all possible palindrome partitions of a palindrome"() {
        when:
            def results = palindromePartitioner.partition("aab")

        then:
            results.size() == 2
            ["aa", "b"] in results
            ["a","a","b"] in results
    }

    def "can determine if a string is a palindrome"() {
        expect:
            palindromePartitioner.isPalindrome("", 0, 0)
            palindromePartitioner.isPalindrome("a", 0, 0)
            palindromePartitioner.isPalindrome("racecar", 0, 6)
            palindromePartitioner.isPalindrome("dood", 0, 3)
            !palindromePartitioner.isPalindrome("spaghetti", 0, 5)
    }

}
