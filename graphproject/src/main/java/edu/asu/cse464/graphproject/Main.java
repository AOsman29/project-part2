package edu.asu.cse464.graphproject;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("=== Starting Graph Project Refactored Part 3 ===");

   
        GraphParser parser = new GraphParser();
        Graph<String, DefaultEdge> loadedGraph = parser.parseGraph("demo.dot");

        System.out.println("\n Parsed graph structure:");
        System.out.println(parser.toString(loadedGraph));

      
        parser.outputGraph(loadedGraph, "graph_summary.txt");
        System.out.println(" Graph summary saved to graph_summary.txt");

     
        GraphManager gm = new GraphManager();

 
        for (String v : loadedGraph.vertexSet()) {
            try { gm.addNode(v); } catch (Exception ignored) {}
        }

  
        for (DefaultEdge e : loadedGraph.edgeSet()) {
            String src = loadedGraph.getEdgeSource(e);
            String dst = loadedGraph.getEdgeTarget(e);

            try { gm.addEdge(src, dst); } catch (Exception ignored) {}
        }

        String src = "a";
        String dst = "h";



        System.out.println("\n===== BFS (Strategy + Template) =====");
        Path bfs = gm.runSearch(src, dst, Algorithm.BFS);
        System.out.println("BFS Path: " + bfs);

        System.out.println("\n===== DFS (Strategy + Template) =====");
        Path dfs = gm.runSearch(src, dst, Algorithm.DFS);
        System.out.println("DFS Path: " + dfs);

        System.out.println("\n===== RANDOM WALK (Strategy + Template) =====");
        for (int i = 1; i <= 5; i++) {
            Path walk = gm.runSearch(src, dst, Algorithm.RANDOM);
            System.out.println("Random Attempt " + i + ": " + walk);
        }

        System.out.println("\n=== Graph Project Completed Successfully ===");
    }
}

//com

