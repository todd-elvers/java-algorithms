package te.interview.prep.strings_arrays

import spock.lang.Specification

@SuppressWarnings("GroovyPointlessBoolean")
class PermutationCheckerTest extends Specification {

    PermutationChecker permutationChecker = []


    def "can determine if one string is a permutation of another"() {
        expect:
            permutationChecker.isPermutation(str1, str2) == expectedResult

        where:
            str1  | str2  || expectedResult
            "abc" | ""    || false
            "abc" | "ab"  || false
            "abc" | "abc" || true
            "abc" | "cba" || true
            "cba" | "cba" || true
            "cba" | "cab" || true
    }

}
