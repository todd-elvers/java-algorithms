package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class MinimumWindowSubstringFinderTest extends Specification {

    @Subject
    MinimumWindowSubstringFinder minimumWindowSubstringFinder = []

    @SuppressWarnings("SpellCheckingInspection")
    def "can find window in str that contains all characters of substr"() {
        expect:
            minimumWindowSubstringFinder.find(str, substr) == window

        where:
            str             | substr || window
            ''              | 'XYZ'  || ''
            'ABC'           | ''     || ''
            'ABC'           | 'XYZ'  || ''
            'a'             | 'a'    || 'a'
            'a'             | 'aa'   || ''
            'aa'            | 'aa'   || 'aa'
            'ADOBECODEBANC' | 'ABC'  || 'BANC'
            '12#$XY'        | '#$Y'  || '#$XY'
    }

}
