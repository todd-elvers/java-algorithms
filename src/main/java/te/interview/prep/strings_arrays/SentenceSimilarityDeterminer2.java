package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/sentence-similarity-ii/">Problem on leetcode</a>
 */
public class SentenceSimilarityDeterminer2 {

    /*
         Time: O(n*p)
            n = length of longest word in sentence
            p = # of pairs
        Space: O(p)
     */
    static class UsingDepthFirstSearch {

        public boolean determine(String[] words1, String[] words2, List<List<String>> pairs) {
            if (words1.length != words2.length) return false;

            Map<String, List<String>> similarityMapping = buildSimilarityMapping(pairs);

            for (int i = 0; i < words1.length; i++) {
                if (words1[i].equals(words2[i])) continue;
                if (!isSimilar(similarityMapping, new HashSet<>(), words1[i], words2[i]))
                    return false;
            }

            return true;
        }

        private Map<String, List<String>> buildSimilarityMapping(List<List<String>> wordPairs) {
            Map<String, List<String>> similarityMapping = new HashMap<>();
            for (List<String> wordPair : wordPairs) {
                similarityMapping
                        .computeIfAbsent(wordPair.get(0), s -> new ArrayList<>())
                        .add(wordPair.get(1));

                similarityMapping
                        .computeIfAbsent(wordPair.get(1), s -> new ArrayList<>())
                        .add(wordPair.get(0));
            }
            return similarityMapping;
        }

        private boolean isSimilar(Map<String, List<String>> similarityMapping, Set<String> wordsTried, String currentWord, String targetWord) {
            if (wordsTried.contains(currentWord) || !similarityMapping.containsKey(currentWord))
                return false;

            wordsTried.add(currentWord);
            for (String nextWord : similarityMapping.get(currentWord)) {
                if (nextWord.equals(targetWord)) return true;
                if (isSimilar(similarityMapping, wordsTried, nextWord, targetWord)) return true;
            }

            return false;
        }
    }

    /*
         Time: O(n * inv_ack(p) + p) ~= O(n+p)
            n = length of longest word (to build disjoint set)
            inv_ack(p) = cost of looking up a word in our disjoint set
            p = size of pairs
        Space: O(p)
     */
    static class UsingDisjointSet {

        public boolean determine(String[] words1, String[] words2, List<List<String>> pairs) {
            if (words1.length != words2.length) return false;

            Map<String, Integer> wordToIndex = new HashMap<>();
            DisjointSet set = generateWordIndexesAndDisjointSet(wordToIndex, pairs);

            for (int i = 0; i < words1.length; i++) {
                if (words1[i].equals(words2[i])) continue;

                Integer index1 = wordToIndex.get(words1[i]);
                Integer index2 = wordToIndex.get(words2[i]);

                // Words cannot be similar if either is absent from `pairs`
                if (index1 == null || index2 == null) return false;

                // Words cannot be similar if they are not part of the same connected component
                if (set.find(index1) != set.find(index2)) return false;
            }

            return true;
        }

        // Generates unique indexes for each word in `pairs` and updates `wordToIndex` with them.
        // Then uses those generated indexes and pairs to build and return a disjoint set.
        private DisjointSet generateWordIndexesAndDisjointSet(Map<String, Integer> wordToIndex, List<List<String>> pairs) {
            DisjointSet disjointSet = new DisjointSet(pairs.size() * 2);

            int count = 0;
            for (List<String> pair : pairs) {
                if (!wordToIndex.containsKey(pair.get(0))) wordToIndex.put(pair.get(0), count++);
                if (!wordToIndex.containsKey(pair.get(1))) wordToIndex.put(pair.get(1), count++);
                disjointSet.union(wordToIndex.get(pair.get(0)), wordToIndex.get(pair.get(1)));
            }

            return disjointSet;
        }

        // Disjoint set where words are represented by integers.  If two words share the same
        // integer they're part of the same set/connected component.
        static class DisjointSet {
            private int[] parents;
            private int[] rank;

            DisjointSet(int n) {
                this.parents = new int[n];
                this.rank = new int[n];
                for (int i = 0; i < n; i++) parents[i] = i;
            }

            int find(int x) {
                if (parents[x] != x) parents[x] = find(parents[x]);
                return parents[x];
            }

            void union(int x, int y) {
                int xSet = find(x), ySet = find(y);
                if (xSet != ySet) {
                    if (rank[xSet] < rank[ySet]) {
                        parents[xSet] = ySet;
                    } else {
                        parents[ySet] = xSet;
                        if (rank[xSet] == rank[ySet]) rank[ySet]++;
                    }
                }
            }
        }
    }
}
