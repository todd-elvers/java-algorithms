package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class StringAdderTest extends Specification {

    @Subject
    StringAdder stringAdder = []

    def "can add two numbers as strings without converting directly to numbers"() {
        expect:
            stringAdder.addStrings(num1, num2) == result

        where:
            num1  | num2 || result
            "0"   | "0"  || "0"
            "429" | "31" || "460"
            "9"   | "9"  || "18"
            "999" | "1"  || "1000"
    }

}
