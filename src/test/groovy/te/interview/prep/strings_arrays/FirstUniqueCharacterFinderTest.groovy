package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class FirstUniqueCharacterFinderTest extends Specification {

    @Subject
    FirstUniqueCharacterFinder finder = []

    @SuppressWarnings("SpellCheckingInspection")
    def "can find the first unique character in a string"() {
        expect:
            finder.firstUniqChar(str) == index

        where:
            str            || index
            null           || -1
            ""             || -1
            "leetcode"     || 0
            "loveleetcode" || 2
            "abcabc"       || -1
    }

}
