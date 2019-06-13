package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/distant-barcodes/">Problem on leetcode</a>
 */
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
     * One call of this method is not always sufficient to correctly rearrange our barcodes.  This
     * scenario usually occurs when we have reached the end of an array of size n and indexes n-1
     * and n-2 are equal.  In this scenario we then wrap around to the start of the array and look
     * for the first different value and swap it with index n-1.  This wrapping logic either
     * completes our rearrangement or moves the values to rearrange to the beginning of the array.
     * In the case where we merely moved the issue up to the front of the array a secondary call to
     * this method will complete the rearrangement.
     *
     * e.g. [2,1,1] will become [1,1,2] after the end of our first 'rearranging' because we started
     * at the middle element and it didn't need to be swapped because the element before it was
     * already different, so we went to the last element and ended up having to start our search for
     * a unique barcode from the beginning of the array.  Since we're not actually completely
     * re-arranged yet another call to this method will get the job done and yield [1,2,1], which is
     * the expected output. Since rearranging an array of barcodes that is already in the correct
     * order does nothing, we always perform a secondary call to this method just in case.
     */
    private void rearrangeBarcodes(int[] barcodes, boolean isFirstRearrangement) {
        for (int i = 1; i < barcodes.length; i++) {
            if (barcodes[i] == barcodes[i - 1]) {
                int swapIndex = findIndexToSwapWith(barcodes, i);

                int temp = barcodes[i];
                barcodes[i] = barcodes[swapIndex];
                barcodes[swapIndex] = temp;
            }
        }

        if (isFirstRearrangement) rearrangeBarcodes(barcodes, false);
    }

    private int findIndexToSwapWith(int[] barcodes, int i) {
        // Return first differing barcode i+1 to the end of barcodes
        for (int j = i + 1; j < barcodes.length; j++) {
            if (barcodes[i] != barcodes[j]) return j;
        }

        // Return first differing barcode from 0 to i-1
        for (int j = 0; j < i; j++) {
            if (barcodes[i] != barcodes[j]) return j;
        }

        throw new IllegalArgumentException("Could not find any barcode aside from " + barcodes[i]);
    }
}

