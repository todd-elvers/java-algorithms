package te.interview.prep.trees_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 4.7 Determine the build order for projects given their dependencies
 * TODO: Determine how to handle cycles in our dependency graph
 * TODO: Lookup definition for Strongly-Connected Components (SCC)
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

        // Given (x,y) this updates y to contain a link to x with x gaining an inLink and y gaining an outLink
        for(String[] dependency : dependencies) {
            DependencyGraph.Node dependentProject = projectNameToNode.get(dependency[0]);           // y
            DependencyGraph.Node projectWithDependency = projectNameToNode.get(dependency[1]);      // x

            projectWithDependency.adjacentNodes.add(dependentProject);
            dependentProject.inLinks++;
            projectWithDependency.outLinks++;
        }

        // Connect nodes with no in-links to the graph
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

        // Add only the project that actually depend on other projects to the graph
        // (We'll handle the orphan dependencies last)
        for (DependencyGraph.Node node : graph.nodes) {
            if(node.outLinks > 0) {
                node.visited = true;
                queue.add(node);
            }
        }

        // BFS the dependency graph
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