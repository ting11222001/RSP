package DataStructure;

import java.util.ArrayList;

/**
 * Graph
 */
public class Graph {

  public void addEdge(ArrayList<ArrayList<Integer>> adjList, int start, int end) {
    // undirected graph
    adjList.get(start).add(end);
    adjList.get(end).add(start);
  }

  public void printGraph(ArrayList<ArrayList<Integer>> adjList) {
    System.out.println("Adjacency List:");
    for (int i = 0; i < adjList.size(); i++) {
      System.out.print("Vertex " + i + " is connected to: ");
      for (int j = 0; j < adjList.get(i).size(); j++) {
        System.out.print(adjList.get(i).get(j) + " -> ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Graph graph = new Graph();

    // create a graph with n vertices
    int vertices = 5;

    // create an arrayList of arrayLists
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(vertices);

    // create sub-arraylists for each vertex
    for (int i = 0; i < vertices; i++) {
      adjList.add(new ArrayList<Integer>());
    }

    // add edges
    /**
     * 0: 1 -> 4
     * 1: 0 -> 4 -> 2 -> 3
     * 2: 1 -> 3
     * 3: 1 -> 4 -> 2
     * 4: 3 -> 0 -> 1
     */
    graph.addEdge(adjList, 0, 1);
    graph.addEdge(adjList, 0, 4);

    graph.addEdge(adjList, 1, 4);
    graph.addEdge(adjList, 1, 2);
    graph.addEdge(adjList, 1, 3);

    graph.addEdge(adjList, 2, 3);
    graph.addEdge(adjList, 3, 4);

    graph.printGraph(adjList);
  }
}
