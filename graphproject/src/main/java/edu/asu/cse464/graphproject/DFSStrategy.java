package edu.asu.cse464.graphproject;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class DFSStrategy implements SearchStrategy {

    @Override
    public Path search(Graph<String, DefaultEdge> graph, String src, String dst) {
        DFSSearch dfs = new DFSSearch();
        return dfs.search(graph, src, dst);
    }
}

//com
