package LeetCode.src.main.java.graph;

import java.util.*;
public class CreateGraph {
    private Map<String,List<String>> adjList;

    CreateGraph(List<String> nodes){
        adjList = new HashMap<>();
        for(String node: nodes){
            adjList.put(node,new ArrayList<>());
        }
    }

    // Directed graph
    public void addEdge(String from,String to){
        adjList.get(from).add(to);
    }

    // Undirected graph
    public void addUndirectedEdge(String node1, String node2){
        adjList.get(node1).add(node2);
        adjList.get(node2).add(node1);

    }

    public void printGraph(){
        for (String node: adjList.keySet()){
            System.out.println(node +"->" + adjList.get(node));
        }
    }

    public static void main(String[] args){
        List<String> nodes = Arrays.asList("Phidim","Illam","Jhapa","Taplejung");

        CreateGraph directedGraph = new CreateGraph(nodes);
        directedGraph.addEdge("Phidim","Illam");
        directedGraph.addEdge("Illam","Jhapa");
        directedGraph.addEdge("Jhapa","Illam");
        directedGraph.addEdge("Taplejung", "Phidim");

        System.out.println("\nDirected Graph");
        directedGraph.printGraph();


        CreateGraph undirectedGraph = new CreateGraph(nodes);
        undirectedGraph.addUndirectedEdge("Phidim","Illam");
        undirectedGraph.addUndirectedEdge("Phidim","Jhapa");
        undirectedGraph.addUndirectedEdge("Jhapa","Illam");
        undirectedGraph.addUndirectedEdge("Jhapa" , "Taplejung");
        System.out.println("\nUndirected Graph");
        undirectedGraph.printGraph();
    }
}
