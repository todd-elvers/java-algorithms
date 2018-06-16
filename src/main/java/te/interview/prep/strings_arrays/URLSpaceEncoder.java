package te.interview.prep.strings_arrays;

public class URLSpaceEncoder {

    public String encode(String str, int trueLength) {
        return encode(str.toCharArray(), trueLength);
    }

    public String encode(char[] chars, int trueLength) {
        int reverseIndex = chars.length - 1;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (Character.isSpaceChar(chars[i])) {
                chars[reverseIndex--] = '0';
                chars[reverseIndex--] = '2';
                chars[reverseIndex--] = '%';
            } else {
                chars[reverseIndex--] = chars[i];
            }
        }

        return new String(chars);
    }

}
