package te.interview.prep.trees_graphs.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GraphNode {
    private String name;
    private GraphNode[] children;
    private boolean visited;

    public GraphNode(String name) {
        this(name, (GraphNode[]) null);
    }

    public GraphNode(String name, GraphNode... children) {
        this.name = name;
        this.children = children;
        this.visited = false;
    }

    public GraphNode(String name, List<GraphNode> children) {
        this.name = name;
        this.children = children.toArray(new GraphNode[children.size()]);
        this.visited = false;
    }

    boolean isLeafNode() {
        return children == null || children.length == 0;
    }

    @Override
    public String toString() {
        LinkedHashMap<GraphNode, List<GraphNode>> nodeToChildren = new LinkedHashMap<>();
        nodeToChildren.put(this, Arrays.asList(children));
        childFinder(children, nodeToChildren);

        StringBuilder output = new StringBuilder();
        for (Map.Entry<GraphNode, List<GraphNode>> entry : nodeToChildren.entrySet()) {
            String nodeName = entry.getKey().name;
            String nodeChildren = entry.getValue().stream().map(child -> child.name).collect(Collectors.joining(", "));

            output.append(nodeName)
                    .append(": ")
                    .append(nodeChildren)
                    .append("\n");
        }

        return output.toString();
    }

    private void childFinder(GraphNode[] children, LinkedHashMap<GraphNode, List<GraphNode>> map) {
        for (GraphNode node : children) {
            if (node.children != null) {
                map.put(node, Arrays.asList(node.children));
                childFinder(node.children, map);
            } else {
                // Base case
                map.put(node, new ArrayList<>());
            }
        }
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GraphNode[] getChildren() {
        return children == null ? new GraphNode[0] : children;
    }

    public void setChildren(GraphNode[] children) {
        this.children = children;
    }

    public void setChildren(List<GraphNode> children) {
        this.children = (GraphNode[]) children.toArray();
    }


}
