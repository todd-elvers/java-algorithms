package te.interview.prep.integers

import spock.lang.Specification
import spock.lang.Subject

class PrimeCounterTest extends Specification {

    @Subject
    PrimeCounter primeCounter = []

    def "can count all prime numbers up to n"() {
        expect:
            primeCounter.countPrimesUpTo(n) == primeCount

        where:
            n     || primeCount
//            10    || 4
//            12    || 5
            25    || 9
//            43443 || 4529
    }

}
