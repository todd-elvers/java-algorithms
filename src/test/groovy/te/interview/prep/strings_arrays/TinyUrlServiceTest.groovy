package te.interview.prep.strings_arrays

import groovy.transform.NotYetImplemented
import spock.lang.Specification
import spock.lang.Subject

class TinyUrlServiceTest extends Specification {

    @Subject
    TinyUrlService tinyUrlService = []

    def "can encode and decode urls to/from tiny urls"() {
        expect:
            tinyUrlService.decode(tinyUrlService.encode(url)) == url

        where:
            url << ["https://www.google.com", "www.google.com"]
    }

}
