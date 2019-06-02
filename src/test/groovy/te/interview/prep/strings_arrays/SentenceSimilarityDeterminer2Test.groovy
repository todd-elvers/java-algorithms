package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class SentenceSimilarityDeterminer2Test extends Specification {

    @Subject
    SentenceSimilarityDeterminer2.UsingDepthFirstSearch dfsApproach = []
    SentenceSimilarityDeterminer2.UsingDisjointSet setApproach = []

    def "can determine if two sentences are similar when transitivity is allowed"() {
        expect:
            dfsApproach.determine(sentence1.split(), sentence2.split(), pairs) == isSimilar
            setApproach.determine(sentence1.split(), sentence2.split(), pairs) == isSimilar

        where:
            sentence1                  | sentence2                | pairs                                                                            || isSimilar
            "great acting skills dude" | "fine drama talent dude" | [["great", "good"], ["fine", "good"], ["acting", "drama"], ["skills", "talent"]] || true

    }

}
