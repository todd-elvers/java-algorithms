package te.interview.prep.trees_graphs;

import java.util.List;
import java.util.Random;

public class WeightedRandomPicker {

    public Item pick(List<Item> items) {
        int sumOfWeights = items.stream().mapToInt(Item::getWeight).sum();

        // Random weight between (1, sumOfWeights]
        int randomWeight = new Random().nextInt(sumOfWeights - 1) + 1;

        for(Item item : items) {
            randomWeight -= item.getWeight();
            if(randomWeight <= 0) {
                return item;
            }
        }

        throw new RuntimeException("Unexpected error while choosing random item");
    }

}

class Item {
    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    String getName() { return name; }
    int getWeight() { return weight; }
}
