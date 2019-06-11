package te.interview.prep.trees_graphs;

import java.util.List;
import java.util.Random;

public class WeightedRandomPicker {

    /**
     * @return an item chosen from `items` using weighted random selection.
     */
    public Item pick(List<Item> items) {
        int sumOfWeights = items.stream().mapToInt(item -> item.weight).sum();

        // Random weight between (1, sumOfWeights]
        int randomWeight = randomIntFrom1To(sumOfWeights);

        // The idea here is that the items with larger weights are more likely to
        // be chosen since they have a greater influence on our randomly chosen
        // weight (i.e. are more likely to cause it to dip to, or below, zero).
        for (Item item : items) {
            randomWeight -= item.weight;
            if (randomWeight <= 0) {
                return item;
            }
        }

        throw new RuntimeException("Unexpected error while choosing random item");
    }

    /**
     * Since nextInt(x) returns (0, x] we subtract one from x to get (0, x-1] so that we can then
     * add one to the result to get our desired interval: (1, x]
     */
    private int randomIntFrom1To(int x) {
        return new Random().nextInt(x - 1) + 1;
    }

    protected static class Item {
        String name;
        int weight;

        public Item(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }
}
