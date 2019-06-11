package te.interview.prep.trees_graphs;

import java.util.List;
import java.util.Random;

public class WeightedRandomPicker {

    /**
     * @return an item chosen from `items` using weighted random selection.
     */
    public Item pick(List<Item> items) {
        int sumOfWeights = items.stream().mapToInt(item -> item.weight).sum();

        // Random weight between [0, sumOfWeights)
        int randomWeight = new Random().nextInt(sumOfWeights) + 1;

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

    protected static class Item {
        String name;
        int weight;

        public Item(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }
}
