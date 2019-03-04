package te.interview.prep.trees_graphs

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

}
