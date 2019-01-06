package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Unroll

@SuppressWarnings("GroovyPointlessBoolean")
class TwoStringPermutationCheckerTest extends Specification {

    @Unroll("given #s1 and #s2 we should return #result")
    def "can determine if one string is a permutation of another"() {
        expect:
            TwoStringPermutationChecker.Approach.USING_SET.apply(s1, s2) == result

        and:
            TwoStringPermutationChecker.Approach.USING_MAP.apply(s1, s2) == result

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
