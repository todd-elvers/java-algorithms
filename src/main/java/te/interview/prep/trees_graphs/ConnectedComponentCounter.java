package te.interview.prep.trees_graphs;

/**
 * @see <a href="https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/">Problem
 * on leetcode</a>
 */
public class ConnectedComponentCounter {

    /*
        Time: O(n + e + inv_ack(e)) ~= O(n + e)
            n = # nodes (when creating our disjoint set)
            e = # edges
            inv_ack(e) = cost of inserting an edge into our disjoint set
        Space: O(n)
     */
    public int count(int numNodes, int[][] edges) {
        if (numNodes <= 0) return 0;
        if (edges.length == 0) return numNodes;

        DisjointSet set = new DisjointSet(numNodes);
        for (int[] edge : edges) {
            set.union(edge[0], edge[1]);
        }

        return set.disjointSetCount;
    }

    @SuppressWarnings("Duplicates")
    private static class DisjointSet {
        int[] parents, ranks;
        int disjointSetCount;

        DisjointSet(int n) {
            this.parents = new int[n];
            this.ranks = new int[n];
            this.disjointSetCount = n;
            for (int i = 0; i < n; i++) parents[i] = i;
        }

        int find(int i) {
            if (i != parents[i]) parents[i] = find(parents[i]);
            return parents[i];
        }

        void union(int x, int y) {
            int xSet = find(x), ySet = find(y);
            if (xSet != ySet) {
                if (ranks[xSet] < ranks[ySet]) {
                    parents[xSet] = ySet;
                } else {
                    parents[ySet] = xSet;
                    if (ranks[xSet] == ranks[ySet]) ranks[ySet]++;
                }
                disjointSetCount--;
            }
        }
    }

}
