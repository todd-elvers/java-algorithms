package te.interview.prep.urlify;

public class URLSpaceEncoder {

    public String encode(String str, int trueLength) {
        return encode(str.toCharArray(), trueLength);
    }

    public String encode(char[] chars, int trueLength) {
        //TODO: Remove buffer
        char[] buffer = new char[10];
        int numBuffChars = 0;

        for (int i = 0; i < trueLength; i++) {
            boolean isSpaceChar = chars[i] == ' ';
            boolean hasBufferChars = numBuffChars > 0;

            if (isSpaceChar) {
                buffer[numBuffChars++] = '%';
                buffer[numBuffChars++] = '2';
                buffer[numBuffChars++] = '0';
            }

            if (hasBufferChars) {
                // Push the current char onto our buffer (ignoring spaces)
                if (!isSpaceChar) {
                    buffer[numBuffChars++] = chars[i];
                }

                // Pop value from buffer and replace current char with it
                chars[i] = buffer[0];

                // Shift the buffer over
                int temp = 0;
                while (temp < numBuffChars) {
                    buffer[temp] = buffer[++temp];
                }

                // Shrink our buffer by one
                numBuffChars--;
            }
        }

        // Write the remaining buffer to the end of the string
        while(numBuffChars > 0) {
            chars[(trueLength-1)+numBuffChars] = buffer[--numBuffChars];
        }

        return new String(chars);
    }

}
