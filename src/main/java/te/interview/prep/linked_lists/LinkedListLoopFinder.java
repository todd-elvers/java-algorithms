package te.interview.prep.linked_lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import te.interview.prep.linked_lists.domain.LoopNode;

public class LinkedListLoopFinder {

    enum Approach {

        // Naive approach - excess memory used but can handle duplicate nodes
        NAIVE(head -> {
            Map<String, List<LoopNode>> nodeDataToNodes = new HashMap<>();
            LoopNode<String> startOfLoop = null;

            LoopNode<String> node = head;
            while (node.next != null) {
                List<LoopNode> nodeReferences = nodeDataToNodes.getOrDefault(node.data, new ArrayList<>());

                if (nodeReferences.contains(node)) {
                    startOfLoop = node;
                    break;
                } else {
                    nodeReferences.add(node);
                    nodeDataToNodes.put(node.data, nodeReferences);
                    node = node.next;
                }
            }

            return Optional.ofNullable(startOfLoop);
        }),

        // Improved approach - minimal memory usage but cannot handle duplicate nodes
        IMPROVED(head -> {
            if (head.next == null) return Optional.empty();

            LoopNode<String> slowNavigator = head;
            LoopNode<String> fastNavigator = head;

            do {
                slowNavigator = slowNavigator.next;
                fastNavigator = fastNavigator.next.next;
            } while (fastNavigator.next.next != null && !fastNavigator.equals(slowNavigator));


            if (fastNavigator.next.next == null) {
                return Optional.empty();
            }


            fastNavigator = head;
            while (!fastNavigator.equals(slowNavigator)) {
                fastNavigator = fastNavigator.next;
                slowNavigator = slowNavigator.next;
            }

            return Optional.of(fastNavigator);
        });


        Function<LoopNode<String>, Optional<LoopNode<String>>> function;

        Approach(Function<LoopNode<String>, Optional<LoopNode<String>>> function) {
            this.function = function;
        }

        public Optional<LoopNode<String>> apply(LoopNode<String> data) {
            return function.apply(data);
        }
    }
}
