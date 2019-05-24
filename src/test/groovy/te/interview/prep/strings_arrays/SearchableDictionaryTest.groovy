package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class SearchableDictionaryTest extends Specification {

    @Subject
    SearchableDictionary dict = []

    def "can correctly handle adding & search for words"() {
        given:
            dict.addWord("bad")
            dict.addWord("dad")
            dict.addWord("mad")

        expect:
            dict.search(searchTerm) == isFound

        where:
            searchTerm || isFound
            "pad"      || false
            "bad"      || true
            ".ad"      || true
            "b.."      || true
            "ba.."     || false
            "..."      || true
    }

}
