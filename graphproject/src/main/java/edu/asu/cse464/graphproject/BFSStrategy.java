package edu.asu.cse464.graphproject;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class BFSStrategy implements SearchStrategy {

    @Override
    public Path search(Graph<String, DefaultEdge> graph, String src, String dst) {
        BFSSearch bfs = new BFSSearch();
        return bfs.search(graph, src, dst);
    }
}
//com
