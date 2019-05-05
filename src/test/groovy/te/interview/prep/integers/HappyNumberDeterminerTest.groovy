package te.interview.prep.integers

import spock.lang.Specification
import te.interview.prep.integers.HappyNumberDeterminer

class HappyNumberDeterminerTest extends Specification {

    HappyNumberDeterminer happyNumberDeterminer = []

    def "can determine whether the square of the digits of a number eventually equals 1"() {
        expect:
            happyNumberDeterminer.isHappy(19)
            !happyNumberDeterminer.isHappy(2)
            !happyNumberDeterminer.isHappy(0)
    }

}
