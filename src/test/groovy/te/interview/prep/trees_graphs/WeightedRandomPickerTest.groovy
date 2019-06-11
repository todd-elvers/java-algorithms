package te.interview.prep.trees_graphs

import spock.lang.Specification

class WeightedRandomPickerTest extends Specification {

    WeightedRandomPicker weightedRandomPicker = []

    def "items with greater weight are chosen more often"() {
        given:
            List<WeightedRandomPicker.Item> items = [
                    new WeightedRandomPicker.Item("A", 5),
                    new WeightedRandomPicker.Item("B", 20),
                    new WeightedRandomPicker.Item("C", 50),
                    new WeightedRandomPicker.Item("D", 10),
                    new WeightedRandomPicker.Item("E", 10),
                    new WeightedRandomPicker.Item("F", 5),
            ]

        and:
            Map<String, Integer> nameToTimesChosen = new TreeMap<>()
            int iterations = 10_000

        when:
            iterations.times {
                def randomItem = weightedRandomPicker.pick(items)
                Integer totalTimesChosen = nameToTimesChosen.get(randomItem.name, 0) + 1
                nameToTimesChosen.put(randomItem.name, totalTimesChosen)
            }

        then:
            printResults(nameToTimesChosen, iterations)

        when:
            iterations.times {
                def randomItem = weightedRandomPicker.pickWithBinarySearch(items)
                Integer totalTimesChosen = nameToTimesChosen.get(randomItem.name, 0) + 1
                nameToTimesChosen.put(randomItem.name, totalTimesChosen)
            }

        then:
            printResults(nameToTimesChosen, iterations)
    }

    private static boolean printResults(Map<String, Integer> nameToTimesChosen, int iterations) {
        println "Results:"
        nameToTimesChosen.each {
            println("$it.key = ${it.value.toString().padRight(4)} (${((it.value/iterations)*100).round()}%)")
        }
        nameToTimesChosen.clear()
        return true
    }
}
