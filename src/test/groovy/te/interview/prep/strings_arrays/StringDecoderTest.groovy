package te.interview.prep.strings_arrays


import spock.lang.Specification
import spock.lang.Subject

class StringDecoderTest extends Specification {

    @Subject
    StringDecoder decoder = []

    def "can decode encoded strings"() {
        expect:
            decoder.decodeString(encoded) == decoded

        where:
            encoded          || decoded
            null             || null
            "3[a]2[bc]"      || "aaabcbc"
            "x3[a2[c]]1[x]d" || "xaccaccaccxd"
            "2[abc]3[cd]ef"  || "abcabccdcdcdef"
            "10[a]"          || "aaaaaaaaaa"
    }

}
