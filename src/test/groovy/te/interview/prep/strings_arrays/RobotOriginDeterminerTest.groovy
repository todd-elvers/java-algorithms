package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class RobotOriginDeterminerTest extends Specification {

    @Subject
    RobotOriginDeterminer robotOriginDeterminer = []

    @SuppressWarnings("SpellCheckingInspection")
    def "can detect if robot returns to origin after executing commands"() {
        expect:
            robotOriginDeterminer.doesRobotEndAtOrigin(commands) == isBackAtOrigin

        where:
            commands         || isBackAtOrigin
            null             || true
            ""               || true
            "UD"             || true
            "LL"             || false
            "URDLURDLURDLRL" || true
    }

}
