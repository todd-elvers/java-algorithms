package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class ImageFlipAndInvertTest extends Specification {

    @Subject
    ImageFlipAndInvert imageFlipAndInvert = []

    def "can flip and invert an int[][]"(int[][] input, int[][] output) {
        expect:
            imageFlipAndInvert.flipAndInvertImage(input) == output

        where:
            input                             || output
            [[1, 1, 0], [1, 0, 1], [0, 0, 0]] || [[1, 0, 0], [0, 1, 0], [1, 1, 1]]
    }

}
