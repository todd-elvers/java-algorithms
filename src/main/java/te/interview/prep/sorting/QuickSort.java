package te.interview.prep.sorting;

public class QuickSort {

    int[] quickSort(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    private int[] quickSort(int[] array, int start, int end) {
        if (start >= end) return array;

        int pivot = partition(array, start, end);

        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);

        return array;
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pivotIndex = start;

        // Build up the left side of the array with values less than the pivot
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                swap(array, i, pivotIndex++);
            }
        }

        // Place our pivot at the end of the left side of the array we just built up
        swap(array, pivotIndex, end);

        return pivotIndex;
    }

    protected void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
