package te.interview.prep.strings_arrays;

public class StringRotationIdentifier {

    boolean isRotated(String s1, String s2) {
        return s1 != null
                && s2 != null
                && s1.length() == s2.length()
                && (s1 + s1).contains(s2);
    }

}
