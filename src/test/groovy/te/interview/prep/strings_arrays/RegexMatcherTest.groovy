package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Unroll

class RegexMatcherTest extends Specification {

    RegexMatcher regexMatcher = []

    @Unroll("#str #message #pattern")
    def "can match strings to patterns"() {
        expect:
            regexMatcher.isMatch(str, pattern) == isMatch

        where:
            str           | pattern      || isMatch
            "aa"          | "a"          || false
            "aa"          | "a*"         || true
            "ab"          | "a*"         || false
            "aa"          | "a*x"        || false
            "ab"          | ".*"         || true
            "aab"         | "c*a*b"      || true
            "aaa"         | "a*a"        || true
            "mississippi" | "mis*is*p*." || false

            message = isMatch ? "matches" : "does not match"
    }
}