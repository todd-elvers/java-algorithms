package te.interview.prep.strings_arrays

import groovy.transform.NotYetImplemented
import spock.lang.Specification
import spock.lang.Subject

class WordCompositionCheckerTest extends Specification {

    @Subject
    WordCompositionChecker wordCompositionChecker = []

    @NotYetImplemented
    @SuppressWarnings("SpellCheckingInspection")
    def "can determine if some input is comprised only of words"() {
        expect:
            wordCompositionChecker.isComprisedOfWords(input, words) == result

        where:
            input           | words                                 || result
            "leetcode"      | ["leet", "code"]                      || true
            "applepenapple" | ["apple", "pen"]                      || true
        //TODO: Comment back in when working on problem
//            "catsandog"     | ["cats", "dog", "sand", "and", "cat"] || false
    }

}
