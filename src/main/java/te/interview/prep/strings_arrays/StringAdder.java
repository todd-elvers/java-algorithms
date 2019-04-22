package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/add-strings/">Problem on leetcode</a>
 */
public class StringAdder {

    public String addStrings(String num1, String num2) {
        String larger = (num1.length() >= num2.length()) ? num1 : num2;
        String smaller = (num2.length() <= num1.length()) ? num2 : num1;
        int lengthDiff = larger.length() - smaller.length();

        boolean remainder = false;
        StringBuilder result = new StringBuilder();
        for (int i = larger.length() - 1; i >= 0; i--) {
            char largerDigit = larger.charAt(i);
            char smallerDigit = (i - lengthDiff < 0) ? '0' : smaller.charAt(i - lengthDiff);

            int sum = Character.getNumericValue(largerDigit)
                    + Character.getNumericValue(smallerDigit)
                    + (remainder ? 1 : 0);

            if (sum > 9) {
                sum = sum % 10;
                remainder = true;
            } else {
                remainder = false;
            }

            result.append(sum);
        }

        if (remainder) {
            result.append("1");
        }

        return result.reverse().toString();
    }


}
