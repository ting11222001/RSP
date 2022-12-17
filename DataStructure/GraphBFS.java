package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * GraphBFS: Directed Graph/ Adjacency Matrix/ BFS
 */
public class GraphBFS {
  int[][] matrix;
  ArrayList<Node> nodes; // an arrayList to store all the nodes

  // constructor
  public GraphBFS(int size) {
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

  // breadthFirstSearch
  public void bfs(int current) {

    // create a queue to stage each node
    Queue<Integer> queue = new LinkedList<>();
    // create a list to track if node is visited
    boolean[] visited = new boolean[matrix.length];

    // add the current node to queue
    queue.offer(current);
    // mark the current node as visited
    visited[current] = true;

    while (queue.size() != 0) {
      // take the first node from queue
      current = queue.poll();
      System.out.println(nodes.get(current).data + " is visited.");

      // add each of the current node's adjacent nodes to the queue
      // only if they're not visited yet
      for (int col = 0; col < matrix[current].length; col++) {
        if (matrix[current][col] == 1 && !visited[col]) {
          queue.offer(col);
          visited[col] = true;
        }
      }
    }
  }

  public static void main(String[] args) {
    // create a graph with n size
    int size = 5;

    /**
     * A → B
     * ↑ ↙ ↓
     * E ←→ C → D
     */

    GraphBFS graph = new GraphBFS(size);
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
     * start from A: A → B → C → E → D
     * start from B: B → C → E → D → A
     * start from C: C → D → E → A → B
     * start from D: D
     * start from E: E → A → C → B → D
     */
    graph.bfs(4);
  }
}