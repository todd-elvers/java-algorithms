package te.interview.prep.strings_arrays;

public class BasicStringCompressor {

    // Runtime = O(uncompressed)
    public String compress(String uncompressed) {
        if (isNotCompressible(uncompressed)) return uncompressed;           // O(1)

        StringBuilder compressed = performCompression(uncompressed);        // O(uncompressed)

        return compressed.length() < uncompressed.length()                  // O(1)
                ? compressed.toString()
                : uncompressed;
    }

    // O(1)
    private boolean isNotCompressible(String str) {
        return str == null || str.length() <= 2;
    }

    // O(uncompressed)
    private StringBuilder performCompression(String uncompressed) {
        StringBuilder compressionBuilder = new StringBuilder();
        int consecutiveCharCount = 0;

        // O(uncompressed)
        for (int i = 0; i < uncompressed.length(); i++) {
            consecutiveCharCount++;

            // O(1)
            boolean isLastChar = (i + 1) == uncompressed.length();
            if (isLastChar || uncompressed.charAt(i) != uncompressed.charAt(i + 1)) {
                compressionBuilder.append(uncompressed.charAt(i));
                compressionBuilder.append(consecutiveCharCount);

                consecutiveCharCount = 0;
            }
        }

        return compressionBuilder;
    }

}
