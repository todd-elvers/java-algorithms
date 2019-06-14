package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class InPlaceStringReverserTest extends Specification {

    @Subject
    InPlaceStringReverser inPlaceStringReverser = []

    def "can reverse a string in-place"() {
        when:
            inPlaceStringReverser.reverse(chars)

        then:
            chars == expectedChars

        where:
            chars                  || expectedChars
            "hello".toCharArray()  || "olleh".toCharArray()
            "Hannah".toCharArray() || "hannaH".toCharArray()
    }

}
