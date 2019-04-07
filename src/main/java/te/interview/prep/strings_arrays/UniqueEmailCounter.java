package te.interview.prep.strings_arrays;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailCounter {

    public int numUniqueEmails(String[] emails) {
        if (emails == null) return 0;

        Set<String> formattedEmails = new HashSet<>();
        for (String email : emails) {
            formattedEmails.add(formatEmail(email));
        }

        return formattedEmails.size();
    }

    private String formatEmail(String email) {
        String[] emailParts = email.split("@");

         return formatLocalName(emailParts[0]) + "@" + emailParts[1];
    }

    private String formatLocalName(String localName) {
        int firstPlusSign = localName.indexOf('+');
        if (firstPlusSign != -1) {
            localName = localName.substring(0, firstPlusSign);
        }
        return localName.replace(".", "");
    }
}
