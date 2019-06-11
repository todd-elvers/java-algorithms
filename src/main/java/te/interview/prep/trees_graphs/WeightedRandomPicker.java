package te.interview.prep.trees_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class WeightedRandomPicker {

    /*
        Time : O(n)
        Space: O(1)
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

    /*
        Time : O(log n)
        Space: O(n)

        This is a modified solution to what I used to solve the following leetcode problem:
        https://leetcode.com/problems/random-pick-with-weight/
     */
    public Item pickWithBinarySearch(List<Item> items) {
        // Here we adjust the weights to cover ranges so we can choose a number
        // between 1-100 to determine our output (having a larger range = higher chance)
        // Given the weights    = [5,  5, 10, 10, 20,  50]
        // rangeAdjustedWeights = [5, 10, 20, 30, 50, 100]
        List<Integer> rangeAdjustedWeights = new ArrayList<>(items.size());
        int sumOfWeights = 0;
        for (Item item : items) {
            sumOfWeights += item.weight;
            rangeAdjustedWeights.add(sumOfWeights);
        }

        // Choose a random number in the range (1, sumOfWeights) and
        // return the element of the range it lands in
        int randomWeight = new Random().nextInt(sumOfWeights) + 1;
        int indexOfRandomElement = binarySearchForClosestWeightRange(
                rangeAdjustedWeights,
                randomWeight,
                false
        );

        return items.get(indexOfRandomElement);
    }

    @SuppressWarnings("SameParameterValue")
    private int binarySearchForClosestWeightRange(List<Integer> weightRanges, int weight, boolean useLibrary) {
        if (useLibrary) {
            // Returns index of `weight` or first index greater than it should exist
            int index = Collections.binarySearch(weightRanges, weight);
            return (index >= 0) ? index : -(index) - 1;
        } else {
            int low = 0, high = weightRanges.size() - 1;
            while (low != high) {
                int mid = low + (high - low) / 2;

                if (weight >= weightRanges.get(mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
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
