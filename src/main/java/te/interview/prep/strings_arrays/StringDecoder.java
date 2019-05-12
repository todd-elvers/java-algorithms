package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/decode-string/">Problem on leetcode</a>
 */
public class StringDecoder {

    // Space: O(n), Time: O(n)  where n is the length of the decoded string
    public String decodeString(String input) {
        if(input == null) return null;

        StringBuilder output = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))) {
                int startingBracketPos = findEncodingStartBracket(input, i);
                int timesEncoded = Integer.parseInt(input.substring(i, startingBracketPos));
                int endingBracketPos = findEncodingEndBracket(input, startingBracketPos);
                output.append(
                        decode(input, timesEncoded, startingBracketPos, endingBracketPos)
                );
                i = endingBracketPos;
            } else {
                output.append(input.charAt(i));
            }
        }

        return output.toString();
    }

    private StringBuilder decode(String input, int timesEncoded, int pos, int endingBracketPos) {
        StringBuilder decodedContents = new StringBuilder();

        while(++pos != endingBracketPos) {
            char c = input.charAt(pos);

            if(Character.isDigit(c)) {
                int startOfEncoding = findEncodingStartBracket(input, pos);
                int nestTimesEncoded = Integer.parseInt(input.substring(pos, startOfEncoding));
                int endOfEncoding = findEncodingEndBracket(input, startOfEncoding);
                decodedContents.append(
                        decode(input, nestTimesEncoded, startOfEncoding, endOfEncoding)
                );
                pos = endOfEncoding;
            } else {
                decodedContents.append(c);
            }
        }

        String decodedBase = decodedContents.toString();
        for(int i = 1; i < timesEncoded; i++) {
            decodedContents.append(decodedBase);
        }

        return decodedContents;
    }

    private int findEncodingStartBracket(String input, int pos) {
        while(input.charAt(++pos) != '[') { }
        return pos;
    }

    private int findEncodingEndBracket(String input, int pos) {
        int numOpen = 1;
        while(numOpen != 0) {
            switch(input.charAt(++pos)) {
                case ']': numOpen--; break;
                case '[': numOpen++; break;
            }
        }

        return pos;
    }

}
