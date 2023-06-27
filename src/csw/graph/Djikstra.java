package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Djikstra {
  public static void minDistance(Graph graph, int source) {
    int[] parent = new int[graph.vertices];
    int[] distance = new int[graph.vertices];
    boolean[] visited = new boolean[graph.vertices];
    for (int i = 0; i < graph.vertices; i++) {
      parent[i] = -1;
      distance[i] = 999999; // infinite
    }
    distance[source] = 0;
    parent[source] = -1;
    EdgeComparator comp = new EdgeComparator();

    // Priority queue is used to Extract min
    PriorityQueue<Edge> queue = new PriorityQueue<Edge>(100, comp);
    Edge edge = new Edge(source, 0);
    queue.add(edge);
    while (!queue.isEmpty()) {
      edge = queue.poll();
      visited[source] = true;
      source = edge.dest;
      // Using BFS
      for (Edge newEdge : graph.adjList[source]) {
        int dest = newEdge.dest;
        int altDist = newEdge.cost + distance[source];

        // If found a shorter path
        if (altDist < distance[dest] && !visited[dest]) {
          distance[dest] = altDist;
          parent[dest] = source;
          edge = new Edge(dest, altDist);
          queue.add(edge);
        }
      }
    }
    // int vertices = graph.vertices;
    System.out.println(Arrays.toString(distance));
    System.out.println(Arrays.toString(parent));
    // for (int i = 0; i < vertices; i++) {
    // if (distance[i] == Integer.MAX_VALUE) {
    // System.out.println("node id " + i + " prev " + parent[i] + " distance :
    // Unreachable");
    // } else {
    // System.out.println("node id " + i + " prev " + parent[i] + " distance : " +
    // distance[i]);
    // }
    // }
  }

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
    minDistance(graph, 1);

  }
}

class EdgeComparator implements Comparator<Edge> {
  public int compare(Edge x, Edge y) {
    if (x.cost < y.cost) {
      return -1;
    }
    if (x.cost > y.cost) {
      return 1;
    }
    return 0;
  }
}