package te.interview.prep.strings

import spock.lang.Specification

class OneAwayCheckerTest extends Specification {

    OneAwayChecker checker = []

    @SuppressWarnings("GroovyPointlessBoolean")
    def "can determine if one string is 1 or 0 edits away from another"() {
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
