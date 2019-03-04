package te.interview.prep.trees_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 4.7 Determine the build order for projects given their dependencies
 */
public class BuildOrderDeterminer {

    public String[] determine(String[] projects, String[][] dependencies) {
        DependencyGraph graph = buildDependencyGraph(projects, dependencies);

        return traverseForBuildOrder(graph, projects.length);
    }

    private DependencyGraph buildDependencyGraph(String[] projects, String[][] dependencies) {
        Map<String, DependencyGraph.Node> projectNameToNode = new HashMap<>();
        for(String projectName : projects) {
            projectNameToNode.put(projectName, new DependencyGraph.Node(projectName));
        }

        for(String[] dependency : dependencies) {
            DependencyGraph.Node dependentProject = projectNameToNode.get(dependency[0]);
            DependencyGraph.Node projectWithDependency = projectNameToNode.get(dependency[1]);

            // Given (x,y) y now contains a link to x, x has another inLink, y has another outLink
            projectWithDependency.adjacentNodes.add(dependentProject);
            dependentProject.inLinks++;
            projectWithDependency.outLinks++;
        }

        DependencyGraph graph = new DependencyGraph();
        for (DependencyGraph.Node node : projectNameToNode.values()) {
            if(node.inLinks == 0) {
                graph.nodes.add(node);
            }
        }

        return graph;
    }

    private String[] traverseForBuildOrder(DependencyGraph graph, int numProjects) {
        LinkedList<DependencyGraph.Node> queue = new LinkedList<>();

        // We must build our array in reverse order since the nodes closest to the
        // root are actually the most dependent ones
        String[] leastToMostDependentProjects = new String[numProjects];
        int buildOrderIndex = numProjects - 1;

        // Populate the queue only with nodes that contain links to other nodes
        for (DependencyGraph.Node node : graph.nodes) {
            if(node.outLinks > 0) {
                node.visited = true;
                queue.add(node);
            }
        }

        while(!queue.isEmpty()) {
            DependencyGraph.Node node = queue.remove();

            leastToMostDependentProjects[buildOrderIndex--] = node.name;

            for(DependencyGraph.Node adjacentNode : node.adjacentNodes) {
                if(!adjacentNode.visited) {
                    adjacentNode.visited = true;
                    queue.add(adjacentNode);
                }
            }
        }

        // Finally, prepend the nodes with no dependencies
        for (DependencyGraph.Node node : graph.nodes) {
            if(node.outLinks == 0) {
                leastToMostDependentProjects[buildOrderIndex--] = node.name;
            }
        }

        return leastToMostDependentProjects;
    }

}

class DependencyGraph {
    static class Node {
        String name;
        List<Node> adjacentNodes = new ArrayList<>();
        int inLinks = 0;
        int outLinks = 0;
        boolean visited = false;

        Node(String name) {
            this.name = name;
        }

    }

    List<Node> nodes = new ArrayList<>();
}