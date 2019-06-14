package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class AnagramGrouperTest extends Specification {

    @Subject
    AnagramGrouper.UsingSorting anagramGrouper = []

    def "can group anagrams correctly"(String[] strings, List<List<String>> groups) {
        expect:
            anagramGrouper.group(strings) == groups

        where:
            strings                                    || groups
            ["eat", "tea", "tan", "ate", "nat", "bat"] || [["eat", "tea", "ate"], ["bat"], ["tan", "nat"]]
    }

}
