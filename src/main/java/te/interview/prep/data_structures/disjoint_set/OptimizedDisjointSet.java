package te.interview.prep.data_structures.disjoint_set;

// Optimized implementation that uses 2 arrays instead of a map
public class OptimizedDisjointSet {
    private int[] parents;
    private int[] rank;

    OptimizedDisjointSet(int[] ints) {
        this.parents = new int[ints.length];
        this.rank = new int[ints.length];

        for (int i = 0; i < ints.length; i++) {
            this.parents[i] = ints[i];
            this.rank[i] = -1;
        }
    }

    public int find(int x) {
        if (x < 0 || x > parents.length - 1) return -1;
        if (x != parents[x]) parents[x] = find(parents[x]);
        return parents[x];
    }

    public void union(int x, int y) {
        int xSet = find(x);
        int ySet = find(y);

        if (xSet == -1 || ySet == -1 || xSet == ySet) return;

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
        if (setRepresentative == -1) return;

        int indexOfSetRep = -1;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] != setRepresentative) {
                indexOfSetRep = i;
            } else if (find(parents[i]) == setRepresentative) {
                parents[i] = -1;
            }
        }

        parents[indexOfSetRep] = 0;
    }
}
