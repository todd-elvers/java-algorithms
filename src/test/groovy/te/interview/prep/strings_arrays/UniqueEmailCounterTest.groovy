package te.interview.prep.strings_arrays

import spock.lang.Specification

class UniqueEmailCounterTest extends Specification {

    UniqueEmailCounter uniqueEmailCounter = []

    def "can determine number of unique emails"() {
        given:
            String[] emails = [
                    "test.email+alex@leetcode.com",
                    "test.e.mail+bob.cathy@leetcode.com",
                    "testemail+david@lee.tcode.com",
                    "test..email+david@leetcode.com",
                    "test..email+david+todd@leetcode.com"
            ] as String[]

        expect:
            uniqueEmailCounter.numUniqueEmails(emails) == 2
    }

}
