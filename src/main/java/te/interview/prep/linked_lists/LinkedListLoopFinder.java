package te.interview.prep.linked_lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import te.interview.prep.linked_lists.domain.LoopNode;

/**
 * @see <a href="https://leetcode.com/problems/linked-list-cycle-ii/">Problem on leetcode</a>
 */
public class LinkedListLoopFinder {

    // Improved approach
    static class FastSlowRunnerApproach {
        Optional<LoopNode<String>> findLoop(LoopNode<String> head) {
            if(head == null || head.next == null) return Optional.empty();

            LoopNode<String> fast = head;
            LoopNode<String> slow = head;

            do {
                slow = slow.next;
                fast = fast.next.next;
            } while(fast != null && fast.next != null && slow != fast);

            if(slow != fast) return Optional.empty();

            fast = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }

            return Optional.of(slow);
        }
    }

    // Naive approach
    static class HashMapApproach {
        Optional<LoopNode<String>> findLoop(LoopNode<String> head) {
            Map<String, List<LoopNode>> nodeDataToNodes = new HashMap<>();
            LoopNode<String> startOfLoop = null;
            LoopNode<String> node = head;

            while (node != null && node.next != null) {
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
        }
    }

}
