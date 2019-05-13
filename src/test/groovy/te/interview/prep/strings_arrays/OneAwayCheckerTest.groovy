package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class OneAwayCheckerTest extends Specification {

    @Subject
    OneAwayChecker checker = []

    @Unroll
    def "returns #expectedResult for '#str1' and '#str2'"() {
        expect:
            checker.isOneAway(str1, str2) == expectedResult

        where:
            str1    | str2   || expectedResult
            "pale"  | "ple"  || true
            "pales" | "pale" || true
            "pale"  | "bale" || true
            "pale"  | "bake" || false
            "pale"  | "ba"   || false
    }

}
