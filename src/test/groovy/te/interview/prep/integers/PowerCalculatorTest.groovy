package te.interview.prep.integers

import spock.lang.Specification
import spock.lang.Subject

class PowerCalculatorTest extends Specification {

    @Subject
    PowerCalculator powerCalculator = []

    def "can calculate x^n"(double x, int n, double result) {
        expect:
            powerCalculator.calculate(x, n).toString().startsWith(result.toString())

        where:
            x       | n          || result
            2.00000 | 0          || 1.0
            2.00000 | 1          || 2.00000
            2.00000 | 10         || 1024.00000
            2.1     | 3          || 9.261
            2.00000 | -2         || 0.25000
            0.44528 | 0          || 1.0
            0.00001 | 2147483647 || 0
            8.88023 | 3          || 700.28148
    }

}
