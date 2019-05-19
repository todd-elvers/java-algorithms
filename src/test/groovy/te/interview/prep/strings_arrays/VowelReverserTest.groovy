package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class VowelReverserTest extends Specification {

    @Subject
    VowelReverser vowelReverser = []

    def "can reverse the vowels in a string"() {
        expect:
            vowelReverser.reverse(str) == reversed

        where:
            str        || reversed
            "hello"    || "holle"
            "leetcode" || "leotcede"
            "what"     || "what"
            "bdc"      || "bdc"
    }

    def "can handle the edge-case of vowels of vowels in differing case"() {
        expect:
            vowelReverser.reverse("heLlO") == "hOLle"
    }

}
