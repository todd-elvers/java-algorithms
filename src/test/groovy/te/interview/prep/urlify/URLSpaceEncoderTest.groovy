package te.interview.prep.urlify

import spock.lang.Specification

class URLSpaceEncoderTest extends Specification {

    URLSpaceEncoder encoder = []

    def "can encode spaces in a string with '%20'"() {
        given:
            String input = "Mr John Smith    "
            String expectedOutput = "Mr%20John%20Smith"
            int trueLength = 13

        expect:
            encoder.encode(input, trueLength) == expectedOutput
    }

}
