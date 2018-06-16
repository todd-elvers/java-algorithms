package te.interview.prep.strings_arrays

import spock.lang.Specification

@SuppressWarnings("GroovyPointlessBoolean")
class PermutationDeciderTest extends Specification {

    PermutationDecider permutationDecider = []

    def "can determine if two strings are permutations"() {
        expect:
            permutationDecider.isPermutation(s1, s2) == result

        where:
            s1       | s2       || result
            'abc'    | 'cba'    || true
            'efffff' | 'feffff' || true
            'a'      | 'abc'    || false
            'def'    | 'abc'    || false
            null     | 'abc'    || false
            'abc'    | null     || false
            null     | null     || false
    }

}
