package edu.asu.cse464.graphproject;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public abstract class SearchTemplate {

    protected Graph<String, DefaultEdge> graph;
    protected String src;
    protected String dst;

    public Path search(Graph<String, DefaultEdge> graph, String src, String dst) {
        this.graph = graph;
        this.src = src;
        this.dst = dst;

        initialize();

        while (!isFinished()) {
            String node = getNextNode();
            if (node == null) break;

            visit(node);

            if (node.equals(dst)) {
                return buildPath(node);
            }

            expand(node);
        }

        return new Path(Collections.emptyList());
    }

    protected abstract void initialize();
    protected abstract boolean isFinished();
    protected abstract String getNextNode();
    protected abstract void expand(String node);
    protected abstract Path buildPath(String goalNode);

    protected void visit(String node) {
      
    }
}

//com
