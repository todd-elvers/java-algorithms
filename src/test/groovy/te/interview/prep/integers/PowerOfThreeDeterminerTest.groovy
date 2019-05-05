package te.interview.prep.integers

import spock.lang.Specification
import spock.lang.Subject

class PowerOfThreeDeterminerTest extends Specification {

    @Subject
    PowerOfThreeDeterminer powerOfThreeDeterminer = []

    def "can determine if a number is a power of two"(int n, boolean isPowerOfThree) {
        expect:
            powerOfThreeDeterminer.isPowerOfThree(n) == isPowerOfThree

        where:
            n           || isPowerOfThree
            -2147483648 || false
            -1          || false
            0           || false
            1           || true
            3           || true
            9           || true
            27          || true
            2147483648  || false
            218         || false
    }

}
