package te.interview.prep.strings_arrays;

import java.util.HashMap;
import java.util.Map;

public class PermutationDecider {

    public boolean isPermutation(String s1, String s2) {
        // O(1)
        if(isNotSameLength(s1, s2)) return false;

        // O(s1)
        Map<Character, Integer> s1CharToCount = new HashMap<>();
        for(char c : s1.toCharArray()) {
            s1CharToCount.put(c, s1CharToCount.getOrDefault(c, 0) + 1);
        }

        // O(s2)
        for(char c : s2.toCharArray()) {
            if(!s1CharToCount.containsKey(c) || s1CharToCount.get(c) == 0) return false;
            s1CharToCount.put(c, s1CharToCount.get(c) - 1);
        }

        // O(s1 + s2)
        return true;
    }

    private boolean isNotSameLength(String s1, String s2) {
        return s1 == null || s2 == null || s1.length() != s2.length();
    }

}
