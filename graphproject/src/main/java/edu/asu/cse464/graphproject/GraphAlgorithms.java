package edu.asu.cse464.graphproject;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class GraphAlgorithms {

    public Path bfs(Graph<String, DefaultEdge> graph, String src, String dst) {
        if (!graph.containsVertex(src) || !graph.containsVertex(dst)) {
            throw new IllegalArgumentException("Source or destination does not exist in graph");
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();

        queue.add(src);
        visited.add(src);
        parent.put(src, null);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(dst)) break;

            for (DefaultEdge edge : graph.outgoingEdgesOf(current)) {
                String neighbor = graph.getEdgeTarget(edge);

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        if (!parent.containsKey(dst)) {
            return new Path(Collections.emptyList());
        }

        List<String> path = new ArrayList<>();
        String steps = dst;

        while (steps != null) {
            path.add(steps);
            steps = parent.get(steps);
        }

        Collections.reverse(path);
        return new Path(path);
    }
}
