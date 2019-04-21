package te.interview.prep.strings_arrays.backtracking

import spock.lang.Specification

class NQueensSolverTest extends Specification {

    NQueensSolver nQueensSolver = []

    def "can generate valid solutions to the n-queens problem"() {
        given:
            int nQueens = 4

        when:
            List<List<String>> solutions = nQueensSolver.solve(nQueens)

        then:
            solutions.size() == 2

        and:
            solutions[0][0] == '.Q..'
            solutions[0][1] == '...Q'
            solutions[0][2] == 'Q...'
            solutions[0][3] == '..Q.'

        and:
            solutions[1][0] == '..Q.'
            solutions[1][1] == 'Q...'
            solutions[1][2] == '...Q'
            solutions[1][3] == '.Q..'
    }

    private static void printSolutions(List<List<String>> solutions) {
        solutions.eachWithIndex { solution, index ->
            println "Solution #${index + 1}"
            solution.each {
                println "\t$it"
            }
        }
    }
}
