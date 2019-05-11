package te.interview.prep.strings_arrays

import groovy.transform.NotYetImplemented
import spock.lang.Specification
import spock.lang.Subject

class StringDecoderTest extends Specification {

    @Subject
    StringDecoder decoder = []

    @NotYetImplemented
    def "can decode encoded strings"() {
        expect:
            decoder.decodeString(encoded) == decoded

        where:
            encoded         || decoded
            "3[a]2[bc]"     || "aaabcbc"
            "3[a2[c]]"      || "accaccacc"
            "2[abc]3[cd]ef" || "abcabccdcdcdef"
    }

}
