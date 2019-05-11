package te.interview.prep.strings_arrays;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/encode-and-decode-tinyurl/">Problem on leetcode</a>
 */
public class TinyUrlService {
    private static final String ENCODED_URL_BASE = "http://tinyurl.com/";
    // In practice we'd need some eviction policy for this so memory doesn't get out of hand
    private final HashMap<String, String> encodedToDecoded = new HashMap<>();

    public String encode(String longUrl) {
        if(longUrl == null) return null;
        String encoded = Integer.toHexString(longUrl.hashCode());
        encodedToDecoded.put(encoded, longUrl);
        return ENCODED_URL_BASE + encoded;
    }

    public String decode(String shortUrl) {
        return encodedToDecoded.get(parseEncodedPathParameter(shortUrl));
    }
    
    private String parseEncodedPathParameter(String url) {
        return url.substring(url.lastIndexOf('/') + 1);
    }
}
