package te.interview.prep.stacks_queues

import spock.lang.Specification

class ParenthesesValidatorTest extends Specification {

    ParenthesesValidator parenthesesValidator = []

    @SuppressWarnings("GroovyPointlessBoolean")
    def "can validate parentheses correctly"() {
        expect:
            parenthesesValidator.isValid(input) == isValid

        where:
            input    || isValid
            "()"     || true
            "()[]{}" || true
            "(]"     || false
            "([)]"   || false
            "{[]}"   || true
            "{["     || false
            "{}}"    || false
    }

}
