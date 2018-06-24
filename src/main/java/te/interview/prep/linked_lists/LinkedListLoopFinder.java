package te.interview.prep.linked_lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import te.interview.prep.linked_lists.domain.LoopNode;
import te.interview.prep.linked_lists.domain.Node;

public class LinkedListLoopFinder {

    Optional<LoopNode<String>> findStartOfLoop(LoopNode<String> head) {
        Map<String, List<LoopNode>> nodeDataToNodes = new HashMap<>();
        LoopNode<String> startOfLoop = null;

        LoopNode<String> node = head;
        while(node.next != null) {
            List<LoopNode> nodeReferences = nodeDataToNodes.getOrDefault(node.data, new ArrayList<>());

            if(nodeReferences.contains(node)) {
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
