package te.interview.prep.strings_arrays.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">Problem on
 * leetcode</a>
 */
public class PhoneNumberToLetterCombinations {
    private static final Map<Character, char[]> DIGIT_TO_CHARS = new HashMap<>();

    static {
        DIGIT_TO_CHARS.put('2', new char[]{'a', 'b', 'c'});
        DIGIT_TO_CHARS.put('3', new char[]{'d', 'e', 'f'});
        DIGIT_TO_CHARS.put('4', new char[]{'g', 'h', 'i'});
        DIGIT_TO_CHARS.put('5', new char[]{'j', 'k', 'l'});
        DIGIT_TO_CHARS.put('6', new char[]{'m', 'n', 'o'});
        DIGIT_TO_CHARS.put('7', new char[]{'p', 'q', 'r', 's'});
        DIGIT_TO_CHARS.put('8', new char[]{'t', 'u', 'v'});
        DIGIT_TO_CHARS.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> generateCombinations(String digits) {
        if(digits == null || digits.isEmpty()) return new ArrayList<>();

        return backtrack(
                digits,
                new ArrayList<>(),
                new StringBuilder(),
                0
        );
    }

    private List<String> backtrack(String digits, List<String> results, StringBuilder result, int digitPos) {
        if(result.length() == digits.length()) {
            results.add(result.toString());
        } else {
            for(int i = digitPos; i < digits.length(); i++) {
                for (char c : DIGIT_TO_CHARS.get(digits.charAt(digitPos))) {
                    result.append(c);
                    backtrack(digits, results, result, i + 1);
                    result.deleteCharAt(result.length() - 1);
                }
            }
        }

        return results;
    }

}
