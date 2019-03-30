package te.interview.prep.trees_graphs

import spock.lang.Specification

@SuppressWarnings("GroovyAssignabilityCheck")
class JudgeFinderTest extends Specification {

    JudgeFinder judgeFinder = []

    def "returns int of judge when they exist and -1 otherwise"() {
        expect:
            judgeFinder.findJudge(n, trustPairs) == judge

        where:
            n | trustPairs                                                         || judge
            0 | createTrustPairs()                                                 || -1
            1 | createTrustPairs()                                                 || 1
            2 | createTrustPairs([[1, 2]])                                         || 2
            2 | createTrustPairs([[1, 2], [2, 1]])                                 || -1
            3 | createTrustPairs([[1, 2], [2, 3]])                                 || -1
            3 | createTrustPairs([[1, 3], [2, 3]])                                 || 3
            4 | createTrustPairs([[1, 3], [1, 4], [2, 3], [2, 4], [4, 3]])         || 3
            4 | createTrustPairs([[1, 3], [1, 4], [2, 3], [2, 4], [4, 3], [3, 4]]) || -1
    }


    private static int[][] createTrustPairs(List<List<Integer>> pairs) {
        if (!pairs) return new int[0][] as int[][]

        List<int[]> trustPairArrays = pairs.collect { pair ->
            [pair[0], pair[1]] as int[]
        }

        int[][] trustPairs = new int[trustPairArrays.size()][] as int[][]
        trustPairArrays.eachWithIndex { int[] entry, int i ->
            trustPairs[i] = entry
        }

        return trustPairs
    }

}
