package te.interview.prep.algorithms_datastructures;

public class MergeSort {

    int[] mergeSort(int[] array) {
        if (array.length <= 1) return array;

        int middle = array.length / 2;
        int[] leftHalf = new int[middle];
        int[] rightHalf = new int[array.length - middle];

        for (int a = 0, l = 0, r = 0; a < array.length; a++) {
            if (l < middle) {
                leftHalf[l++] = array[a];
            } else {
                rightHalf[r++] = array[a];
            }
        }

        leftHalf = mergeSort(leftHalf);
        rightHalf = mergeSort(rightHalf);

        return merge(leftHalf, rightHalf, array);
    }

    protected int[] merge(int[] left, int[] right, int[] original) {
        int l = 0;
        int r = 0;
        int m = 0;

        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                original[m++] = left[l++];
            } else {
                original[m++] = right[r++];
            }
        }

        // Copy the rest over from whichever array still has elements
        while (l < left.length) original[m++] = left[l++];
        while (r < right.length) original[m++] = right[r++];

        return original;
    }
}
