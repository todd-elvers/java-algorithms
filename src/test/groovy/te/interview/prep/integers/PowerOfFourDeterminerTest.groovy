package te.interview.prep.integers

import spock.lang.Specification
import spock.lang.Subject

class PowerOfFourDeterminerTest extends Specification {

    @Subject
    PowerOfFourDeterminer powerOfFourDeterminer = []

    def "can determine if a number is a power of four"(int n, boolean isPowerOfFour) {
        expect:
            powerOfFourDeterminer.isPowerOfFour(n) == isPowerOfFour

        where:
            n           || isPowerOfFour
            -2147483648 || false
            -1          || false
            0           || false
            1           || true
            16          || true
            5           || false
            27          || false
            2147483648  || false
            218         || false
    }

}
