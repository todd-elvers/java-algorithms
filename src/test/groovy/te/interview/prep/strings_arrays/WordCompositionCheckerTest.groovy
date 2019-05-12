package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class WordCompositionCheckerTest extends Specification {

    @Subject
    WordCompositionChecker wordCompositionChecker = []

    @SuppressWarnings("SpellCheckingInspection")
    def "can determine if some input is comprised only of words"() {
        expect:
            wordCompositionChecker.isComprisedOfWords(input, words) == result

        where:
            input           | words                                 || result
            "leetcode"      | ["leet", "code"]                      || true
            "applepenapple" | ["apple", "pen"]                      || true
            "catsandog"     | ["cats", "dog", "sand", "and", "cat"] || false
            "catsanddog"    | ["cat", "dog", "and", "cats"]         || true
            "goalspecial"   | ["go", "goal", "goals", "special"]    || true
            "ccbb"          | ["bc", "cb"]                          || false
    }

    def "can handle very large input"() {
        given:
            String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
            List<String> words = ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"]

        expect:
            !wordCompositionChecker.isComprisedOfWords(input, words)
    }
}
