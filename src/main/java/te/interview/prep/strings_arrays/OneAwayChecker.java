package te.interview.prep.strings_arrays;

public class OneAwayChecker {

    boolean isOneAway(String str1, String str2) {
        if (str1.length() == str2.length()) {
            return isOneReplacementAway(str1, str2);
        } else if (str1.length() + 1 == str2.length()) {
            return isOneEditAway(str1, str2);
        } else if (str1.length() - 1 == str2.length()) {
            return isOneEditAway(str2, str1);
        }

        return false;
    }

    private boolean isOneReplacementAway(String s1, String s2) {
        boolean foundDiff = false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDiff) {
                    return false;
                } else {
                    foundDiff = true;
                }
            }
        }

        return true;
    }

    private boolean isOneEditAway(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;

        while (index2 < s2.length() && index1 < s1.length()) {
            // If we encounter two different characters
            if (s1.charAt(index1) != s2.charAt(index2)){

                // And we're not on the same index
                if (index1 != index2) {
                    // We've found more than one edit
                    return false;
                } else {
                    index2++;
                }
            } else {
                index1++;
                index2++;
            }
        }

        return true;
    }

}
