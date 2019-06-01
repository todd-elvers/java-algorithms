package te.interview.prep.data_structures.trie

import spock.lang.Specification
import spock.lang.Subject

class GeneralTrieOptimizedTrieTest extends Specification {

    @Subject
    GeneralTrie generalTrie = []
    @Subject
    OptimizedTrie optimizedTrie = []

    Map<String, Integer> valuesToInsert = [
            peter  : 1,
            piper  : 2,
            picked : 3,
            peck   : 4,
            pickled: 5,
            peppers: 6
    ]

    def "isEmpty() and insert() work as expected"() {
        expect: 'our trie to start empty'
            generalTrie.isEmpty()
            optimizedTrie.isEmpty()

        when: 'we add a bunch of words to it'
            populateTrie()

        then: 'it is no longer empty'
            !generalTrie.isEmpty()
            !optimizedTrie.isEmpty()
    }

    def "find() work as expected"() {
        given:
            populateTrie()

        expect:
            generalTrie.find('peter') == 1
            optimizedTrie.find('peter') == 1

        and:
            generalTrie.find('pe') == null
            optimizedTrie.find('pe') == null
    }

    def "delete() works as expected"() {
        given:
            populateTrie()

        when:
            generalTrie.delete('peter')
            optimizedTrie.delete('peter')

        then:
            !generalTrie.find('peter')
            !optimizedTrie.find('peter')

        when:
            valuesToInsert.each { key, value ->
                generalTrie.delete(key)
                optimizedTrie.delete(key)
            }

        then:
            generalTrie.isEmpty()
            optimizedTrie.isEmpty()
    }

    private void populateTrie() {
        valuesToInsert.each { key, value ->
            generalTrie.insert(key, value)
            optimizedTrie.insert(key, value)
        }
    }
}
