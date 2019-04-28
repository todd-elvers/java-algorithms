package te.interview.prep.trees_graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JudgeFinder {

    private static final int NO_JUDGE_PRESENT = -1;

    public int findJudge(int n, int[][] trustPairs) {
        if(n == 0) return NO_JUDGE_PRESENT;
        if(n == 1) return n;

        Map<Integer, Trust> personToTrust = new HashMap<>();

        for(int[] trustPair : trustPairs) {
            Trust trustee = personToTrust.getOrDefault(trustPair[0], new Trust());
            trustee.theyTrust.add(trustPair[1]);
            personToTrust.put(trustPair[0], trustee);

            Trust trusted = personToTrust.getOrDefault(trustPair[1], new Trust());
            trusted.trustThem.add(trustPair[0]);
            personToTrust.put(trustPair[1], trusted);
        }

        return personToTrust.entrySet().stream()
                .filter(entry -> entry.getValue().theyTrust.size() == 0)
                .filter(entry -> entry.getValue().trustThem.size() == (n - 1))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(NO_JUDGE_PRESENT);
    }

    static class Trust {
        public Set<Integer> theyTrust = new HashSet<>();
        public Set<Integer> trustThem = new HashSet<>();
    }

}
