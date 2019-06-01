package te.interview.prep.algorithms;

public class MergeSort {

    int[] mergeSort(int[] array) {
        if (array.length <= 1) return array;

        int middle = array.length / 2;
        int[] leftHalf = new int[middle];
        int[] rightHalf = new int[array.length - middle];

        for (int i = 0, left = 0, right = 0; i < array.length; i++) {
            if (left < middle) {
                leftHalf[left++] = array[i];
            } else {
                rightHalf[right++] = array[i];
            }
        }

        leftHalf = mergeSort(leftHalf);
        rightHalf = mergeSort(rightHalf);

        return merge(leftHalf, rightHalf, array);
    }

    protected int[] merge(int[] left, int[] right, int[] original) {
        int lIndex = 0, rIndex = 0, midIndex = 0;

        while (lIndex < left.length && rIndex < right.length) {
            if (left[lIndex] <= right[rIndex]) {
                original[midIndex++] = left[lIndex++];
            } else {
                original[midIndex++] = right[rIndex++];
            }
        }

        // Copy the rest over from whichever array still has elements
        while (lIndex < left.length) original[midIndex++] = left[lIndex++];
        while (rIndex < right.length) original[midIndex++] = right[rIndex++];

        return original;
    }
}
