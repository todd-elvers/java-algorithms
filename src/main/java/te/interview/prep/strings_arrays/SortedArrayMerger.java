package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/">Problem on leetcode</a>
 */
public class SortedArrayMerger {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return;

        // Convert from length to index of last element
        m--;
        n--;

        for(int i = nums1.length - 1; i >= 0; i--) {
            if(n < 0 || m >= 0 && nums1[m] > nums2[n]) {
                nums1[i] = nums1[m--];
            } else {
                nums1[i] = nums2[n--];
            }
        }
    }

}
