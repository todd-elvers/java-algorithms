package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-pairs/">Problem on leetcode</a>
 */
//TODO: Review this later, Trie is useful but it's not immediately obvious why
public class PalindromePairFinder {

    // Time: O(n^2 * k), Space: O(n^2)
    static class UsingBruteForce {
        public List<List<Integer>> find(String[] words) {
            if (words == null || words.length == 0) return Collections.emptyList();
            List<List<Integer>> results = new ArrayList<>();

            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (isPalindrome(words[i] + words[j])) results.add(Arrays.asList(i, j));
                    if (isPalindrome(words[j] + words[i])) results.add(Arrays.asList(j, i));
                }
            }

            return results;
        }

        private boolean isPalindrome(String str) {
            for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
                if (str.charAt(i) != str.charAt(j)) return false;
            }

            return true;
        }
    }

    // Time: O(n * k^2)
    static class UsingTrie {
        public List<List<Integer>> find(String[] words) {
            if (words == null || words.length == 0) return Collections.emptyList();

            List<List<Integer>> results = new ArrayList<>();
            TrieNode root = new TrieNode();

            // Build Trie of suffixes
            for (int i = 0; i < words.length; i++) addWord(root, words[i], i);

            // Search through the suffixes for palindromes
            for (int i = 0; i < words.length; i++) search(words[i], i, root, results);

            return results;
        }

        private void addWord(TrieNode prev, String word, int indexOfWord) {
            // Add words in reverse order so our trie becomes a set of suffixes
            for (int i = word.length() - 1; i >= 0; i--) {
                TrieNode next = prev.getChild(word.charAt(i));
                if(next == null) next = prev.setChild(word.charAt(i), new TrieNode());

                // Then we'll check for a palindrome left->right while we move right pointer to the left.
                // e.g. 'abcd', then 'abc', then 'ab', then 'a'
                if (isPalindrome(word, 0, i)) {
                    // If any of the sub-sequences are a palindrome note it on our `prev` node
                    prev.palindromeIndexes.add(indexOfWord);
                }

                prev = next;
            }

            // Mark the last node we land on as a word
            prev.index = indexOfWord;
        }

        private void search(String word, int indexOfWord, TrieNode current, List<List<Integer>> results) {
            for (int j = 0; j < word.length(); j++) {
                // Edge-case: if some node along our current path is the last node for some other word,
                // see if the remainder of our nodes result in a palindrome.  If they do then the two
                // words themselves comprise a palindrome and should be added to results
                if (isCurrentNodeDifferentWord(indexOfWord, current) && isPalindrome(word, j, word.length() - 1)) {
                    results.add(Arrays.asList(indexOfWord, current.index));
                }

                current = current.getChild(word.charAt(j));

                // Stop searching if any part of `word` is missing from the trie
                if (current == null) return;
            }

            // Did we end on a node representing some other word?  If so that means the word
            // we landed on is a palindrome of our own word since we added all words right->left
            // but searched for them left->right.
            if(current.isWord()) {
                if(indexOfWord != current.index) {
                    results.add(Arrays.asList(indexOfWord, current.index));
                }
            }

            // Add all the palindrome indexes for the node we landed on
            // However don't add them if they point to our word (e.g. single character words)
            for (int j : current.palindromeIndexes) {
                if (j != indexOfWord) {
                    results.add(Arrays.asList(indexOfWord, j));
                }
            }
        }

        private boolean isCurrentNodeDifferentWord(int indexOfWord, TrieNode current) {
            return current.isWord() && current.index != indexOfWord;
        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start++) != s.charAt(end--)) return false;
            }
            return true;
        }

        private static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            List<Integer> palindromeIndexes = new ArrayList<>();
            int index = -1;

            boolean isWord() { return index != -1; }
            TrieNode getChild(char c) {
                return children[toIndex(c)];
            }
            TrieNode setChild(char c, TrieNode n) {
                return children[toIndex(c)] = n;
            }
            private int toIndex(char c) {
                return c - 'a';
            }
        }
    }
}
