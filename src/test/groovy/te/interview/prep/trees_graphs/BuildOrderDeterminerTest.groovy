package te.interview.prep.trees_graphs

import spock.lang.Ignore
import spock.lang.Specification

class BuildOrderDeterminerTest extends Specification {

    BuildOrderDeterminer buildOrderDeterminer = []

    def "can determine the correct build order"() {
        given:
            def projects = ['a', 'b', 'c', 'd', 'e', 'f'] as String[]
            def dependencies = [['a', 'd'], ['f', 'b'], ['b', 'd'], ['f', 'a'], ['d', 'c']] as String[][]

        and:
            def expectedBuildOrder = ['e', 'f', 'b', 'a', 'd', 'c'] as String[]

        expect:
            buildOrderDeterminer.determine(projects, dependencies) == expectedBuildOrder
    }


    @Ignore("This will not pass until my code can handle cycles")
    def "returns null when dependencies contain a cycle"() {
        given:
            def projects = ['a', 'b', 'c', 'd', 'e', 'f'] as String[]
            def dependencies = [['a', 'd'], ['f', 'b'], ['b', 'd'], ['f', 'a'], ['d', 'c'], ['d', 'f']] as String[][]

        expect:
            buildOrderDeterminer.determine(projects, dependencies) == null
    }
}
