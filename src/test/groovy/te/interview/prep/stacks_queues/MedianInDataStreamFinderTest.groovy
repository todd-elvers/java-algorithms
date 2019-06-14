package te.interview.prep.stacks_queues

import spock.lang.Specification
import spock.lang.Subject

class MedianInDataStreamFinderTest extends Specification {

    @Subject
    MedianInDataStreamFinder medianInDataStreamFinder = []

    def "can find median value in an odd sized data stream"() {
        when:
            medianInDataStreamFinder.addNum(4)
            medianInDataStreamFinder.addNum(2)
            medianInDataStreamFinder.addNum(3)

        then:
            medianInDataStreamFinder.findMedian() == 3
    }

    def "can find median value in an even sized data stream"() {
        when:
            medianInDataStreamFinder.addNum(3)
            medianInDataStreamFinder.addNum(2)

        then:
            medianInDataStreamFinder.findMedian() == 2.5d
    }

}
