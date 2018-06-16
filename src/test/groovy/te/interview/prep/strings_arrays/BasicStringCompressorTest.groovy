package te.interview.prep.strings_arrays

import spock.lang.Specification

class BasicStringCompressorTest extends Specification {

    BasicStringCompressor stringCompressor = []

    def "can compress strings"() {
        expect:
            stringCompressor.compress(input) == expectedOutput

        where:
            input               || expectedOutput
            null                || null
            ''                  || ''
            'aabcccccaaa'       || 'a2b1c5a3'
            'abcd'              || 'abcd'
            'aa'                || 'aa'
            'aaaaaaaabcccccccc' || 'a8b1c8'
    }

}
