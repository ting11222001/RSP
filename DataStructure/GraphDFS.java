package DataStructure;

import java.util.ArrayList;

/**
 * GraphDFS: Directed Graph/ Adjacency Matrix/ DFS Recursive
 */
public class GraphDFS {
  int[][] matrix;
  ArrayList<Node> nodes; // an arrayList to store all the nodes

  // constructor
  public GraphDFS(int size) {
    matrix = new int[size][size];
    nodes = new ArrayList<>(); // instantiate the list of nodes
  }

  static class Node {
    String data;

    // constructor
    public Node(String data) {
      this.data = data;
    }
  }

  public void addNode(Node node) {
    nodes.add(node);
  }

  public void addEdge(int start, int end) {
    // create edge for the vertices
    // directed graph
    matrix[start][end] = 1;
  }

  public void printGraphMatrix() {
    System.out.println("Print Graph in Matrix: ");

    // print a row of title:
    System.out.print("  ");
    for (Node node : nodes) {
      System.out.print(node.data + " ");
    }
    System.out.println();

    // print matrix:
    // iterate rows
    for (int i = 0; i < matrix.length; i++) {
      // print each row's node
      System.out.print(nodes.get(i).data + " ");
      // iterate columns
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  // depthFirstSearch
  public void dfs(int current) {
    boolean[] visited = new boolean[matrix.length];

    dfsHelper(current, visited);
  }

  private void dfsHelper(int current, boolean[] visited) {
    // if the current node is visited, then return directly
    if (visited[current]) {
      return;
    } else {
      // mark the current node visited
      visited[current] = true;
      System.out.println(nodes.get(current).data + " is visited.");
    }

    // find the current node's adjacent nodes to keep searching in depth
    for (int col = 0; col < matrix[current].length; col++) {
      if (matrix[current][col] == 1) {
        dfsHelper(col, visited);
      }
    }

    // if a row is fully checked, then return
    return;
  }

  public static void main(String[] args) {
    // create a graph with n size
    int size = 5;

    /**
     * A → B
     * ↑ ↙ ↓
     * E ←→ C → D
     */

    GraphDFS graph = new GraphDFS(size);
    // add node titles
    graph.addNode(new Node("A"));
    graph.addNode(new Node("B"));
    graph.addNode(new Node("C"));
    graph.addNode(new Node("D"));
    graph.addNode(new Node("E"));

    graph.addEdge(0, 1); // A → B
    graph.addEdge(1, 2); // B → C
    graph.addEdge(1, 4); // B → E
    graph.addEdge(2, 3); // C → D
    graph.addEdge(2, 4); // C → E
    graph.addEdge(4, 0); // E → A
    graph.addEdge(4, 2); // E → C

    graph.printGraphMatrix();

    /**
     * Print Graph in Matrix:
     * A B C D E
     * A 0 1 0 0 0
     * B 0 0 1 0 1
     * C 0 0 0 1 1
     * D 0 0 0 0 0
     * E 1 0 1 0 0
     */

    graph.dfs(0);

    /**
     * Result:
     * start from A: A → B → C → D → E
     * start from B: B → C → D → E → A
     * start from C: C → D → E → A → B
     * start from D: D
     * start from E: E → A → B → C → D
     */
  }
}