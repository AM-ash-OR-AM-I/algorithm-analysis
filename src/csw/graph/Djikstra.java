package graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Djikstra {
  public static void minDistance(Graph gph) {
    int[] previous = new int[gph.vertices];
    int[] dist = new int[gph.vertices];
    boolean[] visited = new boolean[gph.vertices];
    int source = 1;
    for (int i = 0; i < gph.vertices; i++) {
      previous[i] = -1;
      dist[i] = 999999; // infinite
    }
    dist[source] = 0;
    previous[source] = -1;
    EdgeComparator comp = new EdgeComparator();
    PriorityQueue<Edge> queue = new PriorityQueue<Edge>(100, comp);
    Edge node = new Edge(source, 0);
    queue.add(node);
    while (queue.isEmpty() != true) {
      node = queue.peek();
      queue.remove();
      visited[source] = true;
      source = node.dest;
      LinkedList<Edge> adl = gph.adjList[source];
      for (Edge adn : adl) {
        int dest = adn.dest;
        int alt = adn.cost;
        if (dist[dest] > alt && visited[dest] == false) {
          dist[dest] = alt;
          previous[dest] = source;
          node = new Edge(dest, alt);
          queue.add(node);
        }
      }
    }
    // printing result.
    int count = gph.vertices;
    for (int i = 0; i < count; i++) {
      if (dist[i] == Integer.MAX_VALUE) {
        System.out.println(" node id " + i + " prev " + previous[i] + " distance Unreachable");
      } else {
        System.out.println(" node id " + i + " prev " + previous[i] + " distance : " +
            dist[i]);
      }
    }
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
    minDistance(graph);

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