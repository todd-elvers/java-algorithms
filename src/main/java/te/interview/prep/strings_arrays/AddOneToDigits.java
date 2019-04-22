package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/plus-one/">Problem on leetcode</a>
 */
public class AddOneToDigits {

    public int[] addOneTo(int[] digits) {
        int remainder = 1;

        // As soon as the remainder is 0 we can stop processing 'digits'
        for(int i = digits.length - 1; i >= 0 && remainder == 1; i--) {
            if(i == digits.length - 1) {
                int oneLarger = digits[i] + 1;
                if(oneLarger > 9) {
                    digits[i] = 0;
                } else {
                    digits[i] = oneLarger;
                    remainder = 0;
                }
            } else {
                int nextValue = digits[i] + remainder;
                if(nextValue > 9) {
                    digits[i] = 0;
                } else {
                    digits[i] = nextValue;
                    remainder = 0;
                }
            }
        }

        return (remainder == 0)
                ? digits
                : expandDigitsToHandleRemainder(digits);
    }

    private int[] expandDigitsToHandleRemainder(int[] digits) {
        int[] expandedDigits = new int[digits.length + 1];
        expandedDigits[0] = 1;
        System.arraycopy(digits, 0, expandedDigits, 1, digits.length);
        return expandedDigits;
    }

}
