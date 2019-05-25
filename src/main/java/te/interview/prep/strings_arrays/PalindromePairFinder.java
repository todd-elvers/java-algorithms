package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-pairs/">Problem on leetcode</a>
 */
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

            System.out.println(Arrays.toString(words));
            root.printTrie(root, '*', 0, "", words);
            System.out.println();

            // Search through the suffixes for palindromes
            for (int i = 0; i < words.length; i++) search(words[i], i, root, results);

            return results;
        }

        private void addWord(TrieNode current, String word, int indexOfWord) {
            System.out.println(word+":");
            // Walk down the trie in the reverse order of `word`'s characters
            for (int i = word.length() - 1; i >= 0; i--) {
                // Fetch the next letter's node (inserting one if null)
                TrieNode next = current.getChildOrInsertNew(word.charAt(i));

                // `indexOfLetter` is a potential pair index if word[0..i] is a palindrome
                System.out.println("\t" + word.charAt(i) + ": " + word + "(" + 0 + ", " + i +") "+ " - " + word.substring(0, i+1) + " - " + isPalindrome(word, 0, i));
                if (isPalindrome(word, 0, i)) {
                    System.out.println("\t\tUpdating letter pointing to '" + word.charAt(i) + "' with reference to " + word + "("+ indexOfWord+")");
                    current.palindromeIndexes.add(indexOfWord);
                }

                current = next;
            }

            // Mark `current` node we landed on as a word
            current.index = indexOfWord;
        }

        private void search(String word, int indexOfWord, TrieNode current, List<List<Integer>> results) {
            System.out.println("Searching for " + word + "(" + indexOfWord + ")");
            for (int j = 0; j < word.length(); j++) {
                if(current.isWord()) {
                    System.out.println("\t" + j + ": (" + current.index + ", " + indexOfWord + ") - " + word + " - " + word.substring(j) + " - " + isPalindrome(word, j, word.length() - 1));
                }

                // Edge-case: if some node along our current path is the last node for some other word,
                // see if the remainder of our nodes result in a palindrome.  If they do then the two
                // words themselves comprise a palindrome and should be added to results
                if (current.isWord() && current.index != indexOfWord && isPalindrome(word, j, word.length() - 1)) {
                    results.add(Arrays.asList(indexOfWord, current.index));
                }

                current = current.getChild(word.charAt(j));

                // Part or all of `word` is missing from Trie, halt search
                if (current == null) return;
            }

            // Did we end on a node representing some other word?  If so that means the word
            // we landed on is a palindrome of our own word since we added all words right->left
            // but searched for them left->right.
            System.out.println("Checking if ended on word...");
            if(current.isWord()) {
                System.out.println("\tYes! Ended on " + current.index + " while traversing for " + word + "(" + indexOfWord + ")");
                if(indexOfWord != current.index) {
                    System.out.println("\t\tAdded!");
                    results.add(Arrays.asList(indexOfWord, current.index));
                }
            }

            // Add all potential pairs indexes, that aren't the index we're currently on, to results
            System.out.println("Adding all pairs (" + current.palindromeIndexes.size() +"):");
            for (int j : current.palindromeIndexes) {
                System.out.println("\tChecking ("+indexOfWord+", "+j+")");
                if (j != indexOfWord) {
                    System.out.println("\t\tAdding it!");
                    results.add(Arrays.asList(indexOfWord, j));
                }
            }
            System.out.println();
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
            TrieNode getChildOrInsertNew(char c) {
                int trieIndex = toIndex(c);
                if(children[trieIndex] == null) children[trieIndex] = new TrieNode();
                return children[trieIndex];
            }
            private int toIndex(char c) {
                return c - 'a';
            }

            private void printTrie(TrieNode node, char c, int offset, String prefix, String[] words) {
                StringBuilder padding = new StringBuilder();
                for(int i = 0; i < offset; i++) padding.append(" ");
                String contents = new StringBuilder(" (")
                    .append(node.index)
                        .append(", ")
                        .append("[")
                        .append(node.palindromeIndexes.stream().map(i -> i+"-"+words[i]).collect(Collectors.joining(",")))
                        .append("]")
                        .append(node.index > 0 ? ", " : "")
                        .append(node.index > 0 ? prefix + c : "")
                        .append(")")
                        .toString();

                System.out.print(padding.toString() + c + contents);
                if(c != '*') prefix += c;
                for (int i = 0; i < node.children.length; i++) {
                    TrieNode child = node.children[i];
                    if (child == null) continue;
                    char ch = (char) (i + 'a');
                    System.out.println();
                    printTrie(child, ch, offset + 2, prefix, words);
                }
            }
        }
    }
}
