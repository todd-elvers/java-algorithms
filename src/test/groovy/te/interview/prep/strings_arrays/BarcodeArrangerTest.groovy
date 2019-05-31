package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class BarcodeArrangerTest extends Specification {

    @Subject
    BarcodeArranger barcodeArranger = []

    def "can rearrange barcodes such that no two adjacent barcodes are equal"(int[] barcodes, int[] rearranged) {
        expect:
            barcodeArranger.rearrangeBarcodes(barcodes) == rearranged

        where:
            barcodes                    || rearranged
            null                        || null
            []                          || []
            [1]                         || [1]
            [1, 2]                      || [1, 2]
            [2, 1, 1]                   || [1, 2, 1]
            [1, 1, 1, 2, 2, 2]          || [1, 2, 1, 2, 1, 2]
            [1, 2, 1, 1, 2, 2]          || [1, 2, 1, 2, 1, 2]
            [1, 1, 1, 1, 2, 2, 3, 3]    || [1, 2, 1, 2, 1, 3, 1, 3]
            [1, 1, 1, 1, 2, 2, 3, 3, 3] || [3, 2, 1, 2, 1, 3, 1, 3, 1]
            [2, 2, 2, 1, 5]             || [2, 1, 2, 5, 2]
            [1, 2, 1, 1, 3, 3, 2, 1]    || [1, 2, 1, 3, 1, 3, 2, 1]
    }

}
