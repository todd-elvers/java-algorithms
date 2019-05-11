package te.interview.prep.trees_graphs

import groovy.transform.NotYetImplemented
import spock.lang.Subject

class BinaryTreeSerializationServiceTest extends TreeTest {

    @Subject
    BinaryTreeSerializationService service = []

    @NotYetImplemented
    def "can serialize & deserialize binary trees to/from a string"() {
        expect:
            service.deserialize(service.serialize(deserialized)) == deserialized

        where:
            deserialized << [
                    generateTree([1, 2, 3, null, null, 4, 5])
            ]
    }

}
