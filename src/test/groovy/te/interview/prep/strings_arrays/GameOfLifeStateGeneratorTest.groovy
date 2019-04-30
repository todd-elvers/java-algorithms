package te.interview.prep.strings_arrays

import groovy.transform.NotYetImplemented
import spock.lang.Specification
import spock.lang.Subject

class GameOfLifeStateGeneratorTest extends Specification {

    @Subject
    GameOfLifeStateGenerator gameOfLifeStateGenerator = []

    @NotYetImplemented
    def "can generate the next state given some existing state"(int[][] board, int[][] nextState) {
        when:
            gameOfLifeStateGenerator.generateNextState(board)

        then:
            board == nextState

        where:
            board << [
                    [
                            [0, 1, 0],
                            [0, 0, 1],
                            [1, 1, 1],
                            [0, 0, 0]
                    ]
            ]

            nextState << [
                    [
                            [0, 0, 0],
                            [1, 0, 1],
                            [0, 1, 1],
                            [0, 1, 0]
                    ]
            ]
    }

}
