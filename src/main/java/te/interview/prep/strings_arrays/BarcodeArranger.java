package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/distant-barcodes/">Problem on leetcode</a>
 */
//TODO: Review this and see how everyone else did it (even though my strategy was 100%/100%)
public class BarcodeArranger {

    // Time: O(n), Space: O(1)
    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes == null || barcodes.length <= 2) return barcodes;
        rearrangeBarcodes(barcodes, true);
        return barcodes;
    }

    /**
     * Swaps adjacent barcodes that are equal until no two adjacent barcodes are equal.
     *
     * One call of this method is not always sufficient to correctly rearrange our barcodes, since
     * some calls result in exhausting the array before the correct number of swaps has been done.
     * In this scenario we have approximated a rearrangement, so a secondary call to this method is
     * required to ensure rearrangement occurred completely. (e.g. [2,1,1] -> [1,1,2] -> [1,2,1])
     */
    private void rearrangeBarcodes(int[] barcodes, boolean performSecondRearranging) {
        for (int i = 1; i < barcodes.length; i++) {
            if (barcodes[i] == barcodes[i - 1]) {
                int swapIndex = findIndexToSwapWith(barcodes, i);

                int temp = barcodes[i];
                barcodes[i] = barcodes[swapIndex];
                barcodes[swapIndex] = temp;
            }
        }

        if (performSecondRearranging) {
            rearrangeBarcodes(barcodes, false);
        }
    }

    private int findIndexToSwapWith(int[] barcodes, int i) {
        // Try to find a different value between i+1 and the end of barcodes
        for (int j = i + 1; j < barcodes.length; j++) {
            if (barcodes[i] != barcodes[j]) {
                return j;
            }
        }

        // Try to find a different value between 0 and i-1
        for (int j = 0; j < i; j++) {
            if (barcodes[i] != barcodes[j]) {
                return j;
            }
        }

        return -1;
    }
}

