package ASSIGNMENT2A;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

class Graph {
  private int vertices;
  private LinkedList<Integer> adjList[];
  private ArrayDeque<Integer> queue;
  private Stack<Integer> stack;

  Graph(int v) {
    vertices = v;
    // Intialize adjacency List
    adjList = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adjList[i] = new LinkedList<>();
    }
    queue = new ArrayDeque<Integer>();
    stack = new Stack<Integer>();
  }

  void addEdge(int v, int w) {
    // Bidirectional edge
    adjList[v].add(w);
    adjList[w].add(v);
  }

  // BFS Traversal
  void BFS(int rootNode) {
    boolean visited[] = new boolean[vertices];
    int node = 0;
    visited[rootNode] = true;
    queue.add(rootNode);

    while (queue.size() != 0) {
      rootNode = queue.poll();
      System.out.print(rootNode + " ");
      for (int i = 0; i < adjList[rootNode].size(); i++) {
        node = adjList[rootNode].get(i);
        if (!visited[node]) {
          visited[node] = true;
          queue.add(node);
        }
      }
    }
  }

  // DFS Traversal
  void DFS(int rootNode) {
    boolean visited[] = new boolean[vertices];
    int node = 0;
    visited[rootNode] = true;
    stack.add(rootNode);

    while (stack.size() != 0) {
      rootNode = stack.pop();
      System.out.print(rootNode + " ");
      for (int i = 0; i < adjList[rootNode].size(); i++) {
        node = adjList[rootNode].get(i);
        if (!visited[node]) {
          visited[node] = true;
          stack.add(node);
        }
      }
    }
  }
}

// Traverse using BFS
public class Q5_Q6 {
  public static void main(String[] args) {
    Graph graph = new Graph(11);

    graph.addEdge(0, 1);
    graph.addEdge(0, 7);
    graph.addEdge(0, 10);
    graph.addEdge(1, 2);
    graph.addEdge(1, 4);
    graph.addEdge(2, 3);
    graph.addEdge(2, 5);
    graph.addEdge(5, 6);
    graph.addEdge(7, 8);
    graph.addEdge(7, 9);

    System.out.println("BFS Traversal of the graph:");
    graph.BFS(0);
    System.out.println("\nDFS Traversal of the graph:");
    graph.DFS(0);
  }
}

/*
 * O/P:
 * BFS Traversal of the graph:
 * 2 1 3 0
 * DFS Traversal of the graph:
 * 2 3 1 0
 */