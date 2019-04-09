package te.interview.prep.strings_arrays;

public class RegexMatcher {

    public boolean isMatch(String str, String pattern) {
        if (str == null || pattern == null) return false;
        return isMatch(str.toCharArray(), 0, pattern.toCharArray(), 0);
    }

    private boolean isMatch(char[] string, int sIndex, char[] pattern, int pIndex) {
        // Base case: we've exhausted the pattern, so we should have also exhausted the string
        if(allCharsProcessed(pattern, pIndex)) {
            return allCharsProcessed(string, sIndex);
        }

        // Patterns can be much longer than strings due to the * operator, so even if we have exhausted
        // the string we need to keep walking down the pattern to ensure no non-* characters exist.
        // e.g. 'a*b*c*d*e*f*' should match against 'a', but 'a*b' should not match against 'a'
        boolean doCharsMatch = !allCharsProcessed(string, sIndex) && doCharsMatch(string[sIndex], pattern[pIndex]);

        if (isStarNextChar(pattern, pIndex)) {
            // Either the string char matches against our 0-or-more pattern char so we should walk down the string further
            // Or we need to compare the string char to the pattern char after the 0-or-more character
            return (doCharsMatch && isMatch(string, sIndex + 1, pattern, pIndex))
                    || isMatch(string, sIndex, pattern, pIndex + 2);
        }

        return doCharsMatch && isMatch(string, sIndex + 1, pattern, pIndex + 1);
    }

    private boolean doCharsMatch(char stringChar, char patternChar) {
        return (stringChar == patternChar || patternChar == '.');
    }

    private boolean allCharsProcessed(char[] chars, int index) {
        return index > chars.length - 1;
    }

    private boolean isStarNextChar(char[] chars, int index) {
        return (index + 1 <= chars.length - 1) && (chars[index + 1] == '*');
    }
}
