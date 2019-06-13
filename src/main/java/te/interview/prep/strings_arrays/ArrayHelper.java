package te.interview.prep.strings_arrays;

/**
 * Utility class comprised of helper functions for arrays (printing, etc.)
 */
public final class ArrayHelper {
    private ArrayHelper() {
    }

    public static void print2D(int[][] array) {
        print2D(array, null);
    }

    public static void print2D(int[][] array, Integer leftPadding) {
        leftPadding = (leftPadding == null) ? 0 : leftPadding;

        System.out.println("[");
        for (int i = 0; i < array.length; i++) {
            System.out.println("  " + i + ": " + printArray(array[i], leftPadding));
        }
        System.out.println("]\n");
    }

    private static String printArray(int[] row, int leftPadding) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < row.length; i++) {
            sb.append(leftPad(row[i], leftPadding));
            if (i < row.length - 1) sb.append(",");
        }
        return sb.append("]").toString();
    }

    private static String leftPad(int x, int amount) {
        StringBuilder sb = new StringBuilder();
        int amountToPad = amount - String.valueOf(x).length();
        for (int i = 0; i < amountToPad; i++) sb.append(" ");
        sb.append(x);
        return sb.toString();
    }

}
