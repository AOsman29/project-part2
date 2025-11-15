package edu.asu.cse464.graphproject;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Graph Project");

        GraphManager manager = new GraphManager();
        manager.addNode("A");
        manager.addNode("B");
        manager.addNode("C");
        manager.addEdge("A", "B");
        manager.addEdge("B", "C");
        manager.addEdge("A", "C");

        String dotFile = "demo_output.dot";

        try {
            manager.exportToDot(dotFile);

            GraphParser parser = new GraphParser();
            Graph<String, DefaultEdge> parsedGraph = parser.parseGraph(dotFile);

            System.out.println(" Parsed graph structure:");
            System.out.println(parser.toString(parsedGraph));

            String summaryFile = "graph_summary.txt";
            parser.outputGraph(parsedGraph, summaryFile);

            System.out.println(" Graph summary saved to " + summaryFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(" Graph Project completed succsess!");
    }
}
