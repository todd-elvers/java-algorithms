package te.interview.prep.trees_graphs


import spock.lang.Subject
import spock.lang.Unroll

class DirectedGraphRouteFinderTest extends DirectedGraphTest {

    @Subject
    DirectedGraphRouteFinder routeFinder = []

    @Unroll("doesRouteExist(#src.name, #dest.name) == #routeExists")
    @SuppressWarnings("GroovyPointlessBoolean")
    def "can determine if a route between two nodes exists"() {
        given:
            resetVisitedFlags()

        expect:
            routeFinder.doesRouteExist(src, dest) == routeExists

        where:
            src | dest || routeExists
            a   | b    || true
            a   | c    || true
            a   | d    || true
            a   | e    || true
            b   | c    || true
            b   | d    || true
            b   | e    || true
            c   | e    || false
            c   | b    || false
            d   | e    || true
            d   | b    || false
            x   | y    || true
            x   | z    || true
            y   | z    || true
            y   | x    || false
            l   | m    || true
            l   | n    || true
            m   | n    || false
            n   | m    || false
            a   | x    || false
            x   | l    || false
            a   | l    || false
    }

}
