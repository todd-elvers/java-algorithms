package te.interview.prep.strings_arrays;

import java.util.HashSet;
import java.util.Set;

public class PermutationChecker {

    // O(s1+s2)
    boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        Set<Character> charsOfStr1 = toSetOfChars(s1);  // O(s1)

        for (char c : s2.toCharArray()) {               // O(s2)
            if (!charsOfStr1.contains(c)) {
                return false;
            }
        }

        return true;
    }

    // O(s)
    private Set<Character> toSetOfChars(String s) {
        Set<Character> chars = new HashSet<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
        return chars;
    }

}
