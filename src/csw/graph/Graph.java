package graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
  protected int vertices;
  protected LinkedList<Edge>[] adjList;
  protected ArrayDeque<Integer> queue;
  protected Stack<Integer> stack;

  class Edge {
    public int dest, cost;

    Edge(int dest, int cost) {
      this.dest = dest;
      this.cost = cost;
    }
  }

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

  private void addWeightedEdge(int source, int dest, int weight) {
    Edge edge = new Edge(dest, weight);
    adjList[source].add(edge);
  }

  void addEdge(int u, int v) {
    addWeightedEdge(u, v, 1);
    addWeightedEdge(v, u, 1);
  }

  void addEdge(int u, int v, int w) {
    addWeightedEdge(u, v, w);
    addWeightedEdge(v, u, w);
  }

  void addDirectedEdge(int source, int dest) {
    addWeightedEdge(source, dest, 1);
  }

  void addDirectedEdge(int source, int dest, int w) {
    addWeightedEdge(source, dest, w);
  }

}
