package te.interview.prep.integers

import spock.lang.Specification
import spock.lang.Subject

class PerfectSquareCounterTest extends Specification {

    @Subject
    PerfectSquareCounter.UsingDynamicProgramming dynamicProgramming = []

    @Subject
    PerfectSquareCounter.UsingFourSquareTheorem fourSquareTheorem = []

    def "can find all perfect squares up to x"() {
        expect:
            dynamicProgramming.countPerfectSquaresUpTo(x) == count
            fourSquareTheorem.countPerfectSquaresUpTo(x) == count

        where:
            x  || count
            0  || 0
            12 || 3
            13 || 2
    }

}
