package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/group-anagrams/">Problem on leetcode</a>
 */
@SuppressWarnings("Duplicates")
public class AnagramGrouper {

    static class UsingSorting {
        public List<List<String>> group(String[] strs) {
            if (strs.length == 0) return Collections.emptyList();

            Map<String, List<String>> ans = new HashMap<>();

            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);

                ans.computeIfAbsent(key, (k) -> new ArrayList<>());
                ans.get(key).add(s);
            }

            return new ArrayList<>(ans.values());
        }
    }

    // Currently incomplete. TODO: Finish this approach.
    static class UsingTrie {
        private Node root = new Node();

        public List<List<String>> group(String[] strs) {
            for (int i = 0; i < strs.length; i++) {
                insert(strs[i], i);
            }

            List<List<String>> anagramGroups = new ArrayList<>();
            List<String> anagrams = new ArrayList<>();

            for (int i = 0; i < strs.length; i++) {
                Integer index = find(strs[i]);

                if (index != null) {
                    anagrams.add(strs[i]);
                }
            }

            return anagramGroups;
        }

        private void insert(String str, int index) {
            Node current = root;

            for (char c : str.toCharArray()) {
                Node next = current.getChild(c);
                if (next == null) {
                    next = new Node();
                    current.setChild(c, next);
                }

                current = next;
            }

            current.index = index;
        }

        private Integer find(String str) {
            Node current = root;

            for (char c : str.toCharArray()) {
                Node next = current.getChild(c);
                if (next == null) return null;
                current = next;
            }

            return current.index;
        }

        static class Node {
            Node[] children = new Node[26];
            Integer index;

            Node getChild(char c) {
                return children[c - 'a'];
            }

            void setChild(char c, Node n) {
                children[c - 'a'] = n;
            }
        }
    }


}
