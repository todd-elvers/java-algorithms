package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class PalindromePairFinderTest extends Specification {

    @Subject
    PalindromePairFinder.UsingBruteForce bfPalindromePairFinder = []
    PalindromePairFinder.UsingTrie triePalindromePairFinder = []

    def "can correctly find the pairs of palindromes"(String[] words, List<List<Integer>> pairs) {
        given:
            def bfResults = bfPalindromePairFinder.find(words)
            def trieResults = triePalindromePairFinder.find(words)
        expect:
            bfResults.size() == pairs.size()
            bfResults.every { it in pairs }
            trieResults.size() == pairs.size()
            trieResults.every { it in pairs }

        where:
            words                                 || pairs
            ["abcd", "dcba", "lls", "s", "sssll"] || [[0, 1], [1, 0], [3, 2], [2, 4]]
            ["ba", "a", "aaa"]                    || [[1, 0], [1, 2], [2, 1]]
            ["bat", "tab", "cat"]                 || [[0, 1], [1, 0]]
    }

}
