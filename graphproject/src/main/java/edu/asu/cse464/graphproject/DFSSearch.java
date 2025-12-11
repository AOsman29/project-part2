package edu.asu.cse464.graphproject;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class DFSSearch extends SearchTemplate {

    private Stack<String> stack;
    private Set<String> visited;
    private Map<String, String> parent;

    @Override
    protected void initialize() {
        stack = new Stack<>();
        visited = new HashSet<>();
        parent = new HashMap<>();

        stack.push(src);
        parent.put(src, null);
    }

    @Override
    protected boolean isFinished() {
        return stack.isEmpty();
    }

    @Override
    protected String getNextNode() {
        String node = stack.pop();
        visited.add(node);
        return node;
    }

    @Override
    protected void expand(String node) {
        for (DefaultEdge e : graph.outgoingEdgesOf(node)) {
            String neighbor = graph.getEdgeTarget(e);
            if (!visited.contains(neighbor)) {
                stack.push(neighbor);
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
