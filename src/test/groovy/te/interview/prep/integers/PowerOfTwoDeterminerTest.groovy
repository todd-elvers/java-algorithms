package te.interview.prep.integers

import spock.lang.Specification
import spock.lang.Subject

class PowerOfTwoDeterminerTest extends Specification {

    @Subject
    PowerOfTwoDeterminer powerOfTwoDeterminer = []

    def "can determine if a number is a power of two"() {
        expect:
            powerOfTwoDeterminer.isPowerOfTwo(n) == isPowerOfTwo

        where:
            n           || isPowerOfTwo
            0           || false
            1           || true
            16          || true
            256         || true
            218         || false
            536870912   || true
            -2147483648 || false
            -1          || false
    }

}
