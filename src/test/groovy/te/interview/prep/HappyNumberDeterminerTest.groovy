package te.interview.prep

import spock.lang.Specification

class HappyNumberDeterminerTest extends Specification {

    HappyNumberDeterminer happyNumberDeterminer = []

    def "can determine whether the square of the digits of a number eventually equals 1"() {
        expect:
            happyNumberDeterminer.isHappy(19)
            !happyNumberDeterminer.isHappy(2)
            !happyNumberDeterminer.isHappy(0)
    }

}
