package te.interview.prep.data_structures.disjoint_set;

// Optimized implementation that uses 2 arrays instead of a map
public class OptimizedDisjointSet {
    private static final int NON_EXISTENT = -1;

    private int[] parents;
    private int[] rank;

    OptimizedDisjointSet(int[] ints) {
        this.parents = new int[ints.length];
        this.rank = new int[ints.length];

        for (int i = 0; i < ints.length; i++) {
            this.parents[i] = ints[i];
        }
    }

    public int find(int x) {
        if (x < 0 || x > parents.length - 1) return NON_EXISTENT;
        if (x != parents[x]) parents[x] = find(parents[x]);
        return parents[x];
    }

    public void union(int x, int y) {
        int xSet = find(x), ySet = find(y);
        if (xSet == NON_EXISTENT || ySet == NON_EXISTENT || xSet == ySet) return;

        unionByRank(xSet, ySet);
    }

    private void unionByRank(int xSet, int ySet) {
        if (rank[xSet] < rank[ySet]) {
            parents[xSet] = ySet;
        } else {
            parents[ySet] = xSet;

            if (rank[xSet] == rank[ySet]) {
                rank[ySet] += 1;
            }
        }
    }

    public void remove(int x) {
        int setRepresentative = find(x);
        if (setRepresentative == NON_EXISTENT) return;

        // Remove all nodes who's set representative is x
        int indexOfSetRep = NON_EXISTENT;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] != setRepresentative) {
                indexOfSetRep = i;
            } else if (find(parents[i]) == setRepresentative) {
                parents[i] = NON_EXISTENT;
            }
        }

        // Remove x itself
        parents[indexOfSetRep] = NON_EXISTENT;
    }
}
