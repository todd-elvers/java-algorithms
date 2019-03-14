package te.interview.prep.trees_graphs

import spock.lang.Specification

class WeightedRandomPickerTest extends Specification {

    WeightedRandomPicker weightedRandomPicker = []

    def "items with greater weight are chosen more often"() {
        given:
            List<Item> items = [
                    new Item("A", 5),
                    new Item("B", 20),
                    new Item("C", 50),
                    new Item("D", 10),
                    new Item("E", 10),
                    new Item("F", 5),
            ]

        and:
            Map<String, Integer> nameToTimesChosen = new TreeMap<>()
            int iterations = 10_000

        when:
            iterations.times {
                Item randomItem = weightedRandomPicker.pick(items)
                Integer totalTimesChosen = nameToTimesChosen.get(randomItem.name, 0) + 1
                nameToTimesChosen.put(randomItem.name, totalTimesChosen)
            }

        then:
            println "Results:"
            nameToTimesChosen.each {
                println("$it.key = $it.value (${(it.value/iterations)*100})")
            }

        and:
            true
    }

}
