package te.interview.prep.strings;

import java.util.HashSet;
import java.util.Set;

public class PermutationChecker {

    boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        Set<Character> charsOfStr1 = toSetOfChars(str1);

        for (char c : str2.toCharArray()) {
            if (!charsOfStr1.contains(c)) {
                return false;
            }
        }

        return true;
    }

    private Set<Character> toSetOfChars(String str) {
        Set<Character> charsOfStr1 = new HashSet<>();
        for (char c : str.toCharArray()) {
            charsOfStr1.add(c);
        }
        return charsOfStr1;
    }

}
