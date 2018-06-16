package te.interview.prep.strings_arrays

import spock.lang.Specification

@SuppressWarnings("GroovyPointlessBoolean")
class StringRotationIdentifierTest extends Specification {

    StringRotationIdentifier rotationIdentifier = []

    def "can identify rotated strings"(String s1, String s2, boolean expectedResult) {
        expect:
            rotationIdentifier.isRotated(s1, s2) == expectedResult

        where:
            s1            | s2            || expectedResult
            'erbottlewat' | 'waterbottle' || true
            'erbottlewat' | 'waterbtotle' || false
            'abc'         | 'bca'         || true
            'abc'         | 'bc'          || false
            'abc'         | null          || false
            null          | 'abc'         || false
            null          | null          || false
    }
}
