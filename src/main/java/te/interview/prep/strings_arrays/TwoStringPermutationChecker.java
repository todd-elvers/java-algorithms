package te.interview.prep.strings_arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TwoStringPermutationChecker {

    enum Approach {

        USING_SET((s1, s2) -> {
            if (s1 == null || s2 == null || s1.length() != s2.length()) return false;

            // O(s1)
            Set<Character> charsOfStr1 = new HashSet<>();
            for (char c : s1.toCharArray()) {
                charsOfStr1.add(c);
            }

            // O(s2)
            for (char c : s2.toCharArray()) {
                if (!charsOfStr1.contains(c)) {
                    return false;
                }
            }

            return true;
        }),

        USING_MAP((s1, s2) -> {
            // O(1)
            if(s1 == null || s2 == null || s1.length() != s2.length()) return false;

            Map<Character, Integer> s1CharToCount = new HashMap<>();

            // O(s1)
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
        });

        BiFunction<String, String, Boolean> function;

        Approach(BiFunction<String, String, Boolean> function) {
            this.function = function;
        }

        public boolean apply(String s1, String s2) {
            return this.function.apply(s1, s2);
        }
    }

}
