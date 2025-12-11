package edu.asu.cse464.graphproject;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.Graph;

import java.util.*;

public class BFSSearch extends SearchTemplate {

    private Queue<String> queue;
    private Set<String> visited;
    private Map<String, String> parent;

    @Override
    protected void initialize() {
        queue = new LinkedList<>();
        visited = new HashSet<>();
        parent = new HashMap<>();

        queue.add(src);
        visited.add(src);
        parent.put(src, null);
    }

    @Override
    protected boolean isFinished() {
        return queue.isEmpty();
    }

    @Override
    protected String getNextNode() {
        return queue.poll();
    }

    @Override
    protected void expand(String node) {
        for (DefaultEdge e : graph.outgoingEdgesOf(node)) {
            String neighbor = graph.getEdgeTarget(e);
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.add(neighbor);
                parent.put(neighbor, node);
            }
        }
    }

    @Override
    protected Path buildPath(String goalNode) {
        List<String> path = new ArrayList<>();
        for (String cur = goalNode; cur != null; cur = parent.get(cur)) {
            path.add(cur);
        }
        Collections.reverse(path);
        return new Path(path);
    }
}
