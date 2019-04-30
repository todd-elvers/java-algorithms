package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">Problem on leetcode</a>
 */
public class SortedArrayMedianFinder {

    public double find(int[] nums1, int[] nums2) {
        int nums1Index = 0, nums2Index = 0;
        boolean isEvenLength = (nums1.length + nums2.length) % 2 == 0;

        // The values we're looking for
        Integer targetValue1 = null,
                targetValue2 = null;

        // The indexes those values reside at
        int targetIndex1 = (nums1.length + nums2.length) / 2,
            targetIndex2 = isEvenLength ? targetIndex1 - 1 : -1;

        for (int i = 0; targetValue1 == null || (isEvenLength && targetValue2 == null); i++) {
            Integer v1 = (nums1Index < nums1.length) ? nums1[nums1Index] : null;
            Integer v2 = (nums2Index < nums2.length) ? nums2[nums2Index] : null;

            // Use the smaller value between v1 & v2 and
            // increment the index of the array it came from
            int value;
            if (v2 == null || v1 != null && v1 < v2) {
                value = v1;
                nums1Index++;
            } else {
                value = v2;
                nums2Index++;
            }

            if (i == targetIndex1) targetValue1 = value;
            if (isEvenLength && i == targetIndex2) targetValue2 = value;
        }

        return calculateMedian(targetValue1, targetValue2);
    }

    private double calculateMedian(Integer value1, Integer value2) {
        if (value2 == null) {
            return (double) value1;
        } else {
            return ((double) (value1 + value2)) / 2;
        }
    }
}
