package edu.asu.cse464.graphproject;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class RandomWalkStrategy implements SearchStrategy {

    private final int maxSteps;

    public RandomWalkStrategy(int maxSteps) {
        this.maxSteps = maxSteps;
    }

    @Override
    public Path search(Graph<String, DefaultEdge> graph, String src, String dst) {

    
        GraphAlgorithms alg = new GraphAlgorithms();
        return alg.randomWalk(graph, src, dst, maxSteps);
    }
}

//com

