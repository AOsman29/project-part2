package edu.asu.cse464.graphproject;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public interface SearchStrategy {
    Path search(Graph<String, DefaultEdge> graph, String src, String dst);
}

//com

