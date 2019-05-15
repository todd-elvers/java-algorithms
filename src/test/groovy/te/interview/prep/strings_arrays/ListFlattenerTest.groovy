package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll
import te.interview.prep.strings_arrays.ListFlattener.NestedInteger

class ListFlattenerTest extends Specification {

    @Subject
    ListFlattener listFlattener

    @Unroll("can flatten #appearance into #output")
    def "can flatten a list of integers & lists to a list of integers"() {
        given:
            listFlattener = [input]
            List<Integer> results = []

        when:
            while (listFlattener.hasNext()) {
                results << listFlattener.next()
            }

        then:
            results == output

        where:
            input                     | appearance   || output
            mockListEndingWithEmpty() | "[[1],[]]"   || [1]
            mockEmptyLists()          | "[[],[]]"    || []
            mockList([])              | "[]"         || []
            mockList([1])             | "[1]"        || [1]
            mockList([1, 2])          | "[1,2]"      || [1, 2]
            mockMixed()               | "[1,[2,[3]]" || [1, 2, 3]
            mockDeepList()            | "[[[1]]]"    || [1]
    }


    def "can correctly mock the behavior of NestedInteger"() {
        given:
            def simpleInt = mockSimple(1)
            def simpleList = mockList([1, 2])
            def mixed = mockMixed()
            def deepOne = mockDeepList()

        expect:
            simpleInt instanceof NestedInteger
            simpleInt.isInteger()
            simpleInt.getInteger() == 1
            simpleInt.getList() == null

        and:
            simpleList instanceof List<NestedInteger>
            simpleList.every { it instanceof NestedInteger }
            simpleList*.getInteger() == [1, 2]

        and:
            mixed instanceof List<NestedInteger>
            mixed*.isInteger() == [true, false]
            [
                    mixed[0].getInteger(),
                    mixed[1].getList()[0].getInteger(),
                    mixed[1].getList()[1].getList()[0].getInteger()
            ] == [1, 2, 3]

        and:
            deepOne instanceof List<NestedInteger>
            deepOne[0].getList()[0].getList()[0].getList()[0].getInteger() == 1
    }

    private NestedInteger mockSimple(Integer i) {
        return Mock(NestedInteger) {
            isInteger() >> true
            getInteger() >> i
            getList() >> null
        }
    }

    private List<NestedInteger> mockList(List<Integer> integers) {
        integers.collect { mockSimple(it) }
    }

    private List<NestedInteger> mockMixed() {
        return [
                mockSimple(1),
                Mock(NestedInteger) {
                    isInteger() >> false
                    getInteger() >> null
                    getList() >> [
                            mockSimple(2),
                            Mock(NestedInteger) {
                                isInteger() >> false
                                getInteger() >> null
                                getList() >> [
                                        mockSimple(3)
                                ]
                            }
                    ]
                }
        ]
    }

    private List<NestedInteger> mockDeepList() {
        [
                Mock(NestedInteger) {
                    isInteger() >> false
                    getInteger() >> null
                    getList() >> [
                            Mock(NestedInteger) {
                                isInteger() >> false
                                getInteger() >> null
                                getList() >> [
                                        Mock(NestedInteger) {
                                            isInteger() >> false
                                            getInteger() >> null
                                            getList() >> [
                                                    mockSimple(1)
                                            ]
                                        }
                                ]
                            }
                    ]
                }
        ]
    }

    private List<NestedInteger> mockEmptyLists() {
        return [
                Mock(NestedInteger) {
                    isInteger() >> false
                    getInteger() >> null
                    getList() >> []
                },
                Mock(NestedInteger) {
                    isInteger() >> false
                    getInteger() >> null
                    getList() >> []
                }
        ]
    }

    private List<NestedInteger> mockListEndingWithEmpty() {
        return [
                Mock(NestedInteger) {
                    isInteger() >> false
                    getInteger() >> null
                    getList() >> [
                            mockSimple(1)
                    ]
                },
                Mock(NestedInteger) {
                    isInteger() >> false
                    getInteger() >> null
                    getList() >> []
                }
        ]
    }

}
