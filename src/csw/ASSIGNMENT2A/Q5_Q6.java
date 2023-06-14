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
  void BFS(int root) {
    boolean visited[] = new boolean[vertices];
    int node = 0;
    visited[root] = true;
    queue.add(root);

    while (queue.size() != 0) {
      root = queue.poll();
      System.out.print(root + " ");
      for (int i = 0; i < adjList[root].size(); i++) {
        node = adjList[root].get(i);
        if (!visited[node]) {
          visited[node] = true;
          queue.add(node);
        }
      }
    }
  }

  // DFS Traversal
  void DFS(int root) {
    boolean visited[] = new boolean[vertices];
    int node = 0;
    visited[root] = true;
    stack.add(root);

    while (stack.size() != 0) {
      root = stack.pop();
      System.out.print(root + " ");
      for (int i = 0; i < adjList[root].size(); i++) {
        node = adjList[root].get(i);
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
    Graph graph = new Graph(6);

    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(1, 3);

    System.out.println("BFS Traversal of the graph:");
    graph.BFS(2);
    System.out.println("\nDFS Traversal of the graph:");
    graph.DFS(2);
  }
}

/*
 * O/P:
 * BFS Traversal of the graph:
 * 2 1 3 0
 * DFS Traversal of the graph:
 * 2 3 1 0
 */