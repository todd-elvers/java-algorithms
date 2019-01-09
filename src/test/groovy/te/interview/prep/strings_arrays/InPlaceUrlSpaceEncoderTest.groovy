package te.interview.prep.strings_arrays

import spock.lang.Specification

class InPlaceUrlSpaceEncoderTest extends Specification {

    InPlaceUrlSpaceEncoder encoder = []

    def "can encode spaces in a string with '%20' in-place"() {
        given:
            String input = "Mr John Smith    "
            String expectedOutput = "Mr%20John%20Smith"
            int trueLength = 13

        expect:
            encoder.encode(input, trueLength) == expectedOutput
    }

}
