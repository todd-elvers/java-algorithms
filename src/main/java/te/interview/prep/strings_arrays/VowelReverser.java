package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">Problem on leetcode</a>
 */
public class VowelReverser {

    public String reverse(String s) {
        if (s == null || s.length() == 0) return s;

        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {
            boolean ithCharIsVowel = isVowel(chars[i]);
            boolean jthCharIsVowel = isVowel(chars[j]);

            if (ithCharIsVowel && jthCharIsVowel) {
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            } else {
                if (!ithCharIsVowel) i++;
                if (!jthCharIsVowel) j--;
            }
        }

        return new String(chars);
    }


    private boolean isVowel(char letter) {
        switch (Character.toLowerCase(letter)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;

            default:
                return false;
        }
    }

}
